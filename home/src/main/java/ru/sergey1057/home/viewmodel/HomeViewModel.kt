package ru.sergey1057.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.sergey1057.home.models.TeamModel
import ru.sergey1057.home.webApi.WebApi
import javax.inject.Inject


class HomeViewModel
constructor(
    webApi : WebApi
) : ViewModel() {
    private val cd = CompositeDisposable()

    private val _packetLiveData = MutableLiveData<Result>()
    val packetLiveData: LiveData<Result> = _packetLiveData


    init {
        cd.add(
        webApi
            .getPacket()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    val teams = response.standings[0].table.map {
                        TeamModel(it.position.toString(), it.team.name, it.playedGames.toString(), it.points.toString() )
                    }
                    _packetLiveData.value = Success(teams)
                },
                {
                    _packetLiveData.value = Error(it.localizedMessage)
                }
            )
        )
    }

    override fun onCleared() {
        cd.dispose()
        super.onCleared()
    }
}

class HomeViewModelFactory @Inject constructor(
    private val webApi : WebApi
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(webApi) as T
    }
}

sealed class Result
data class Success(val teamModels: List<TeamModel>) : Result()
data class Error(val message: String) : Result()
object ServerError : Result()