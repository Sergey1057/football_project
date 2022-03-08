package ru.sergey1057.scorers.webApi

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import ru.sergey1057.scorers.dto.ScorersPacket


interface WebApi {

    @GET("competitions/PL/scorers")
    fun getPacket(@Header("X-Auth-Token") token: String = "b6d85daeac7547729536242bed22459a"): Single<ScorersPacket>
}