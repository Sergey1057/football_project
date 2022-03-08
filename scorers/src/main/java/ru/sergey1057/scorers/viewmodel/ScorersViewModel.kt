package ru.sergey1057.scorers.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.sergey1057.scorers.dto.Scorers
import ru.sergey1057.scorers.dto.ScorersPacket
import ru.sergey1057.scorers.models.ScorerModel
import ru.sergey1057.scorers.webApi.WebApi
import java.util.*
import javax.inject.Inject

class ScorersViewModel
constructor(
    private val webApi : WebApi
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
                        val scorers: List<ScorerModel> =
                            response.scorers.mapIndexed { index, model ->
                            ScorerModel(
                                (index + 1).toString(),
                                model.player.name,
                                model.team.name,
                                model.player.nationality,
                                model.numberOfGoals.toString()
                            )
                        }
                        _packetLiveData.value = Success(scorers)
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

class ScorersViewModelFactory @Inject constructor(
    private val webApi : WebApi
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ScorersViewModel(webApi) as T
    }
}

sealed class Result
data class Success(val scorers: List<ScorerModel>) : Result()
data class Error(val message: String) : Result()
object ServerError : Result()