package ru.sergey1057.world.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.sergey1057.world.models.WorldModel
import ru.sergey1057.world.webApi.WebApi
import java.util.*
import javax.inject.Inject

class WorldViewModel
constructor(
    private val webApi: WebApi
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
                        val chempions: List<WorldModel> =
                            response.seasons.mapIndexed { index, model ->
                                WorldModel(
                                    (index + 1).toString(),
                                    model.startDate.substring(0, 4),
                                    model.winner.name,
                                )
                            }
                        _packetLiveData.value = Success(chempions)
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

class WorldViewModelFactory @Inject constructor(
    private val webApi: WebApi
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WorldViewModel(webApi) as T
    }
}

sealed class Result
data class Success(val chempions: List<WorldModel>) : Result()
data class Error(val message: String) : Result()
object ServerError : Result()