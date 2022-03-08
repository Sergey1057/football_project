package ru.sergey1057.world.webApi

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import ru.sergey1057.world.dto.WorldPacket


interface WebApi {

    @GET("competitions/2000")
    fun getPacket(@Header("X-Auth-Token") token: String = "b6d85daeac7547729536242bed22459a"): Single<WorldPacket>
}