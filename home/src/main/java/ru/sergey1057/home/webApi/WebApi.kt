package ru.sergey1057.home.webApi

import retrofit2.http.GET
import retrofit2.http.Header
import ru.sergey1057.home.dto.Packet
import io.reactivex.Single

interface WebApi {

    @GET("competitions/PL/standings")
    fun getPacket(@Header("X-Auth-Token") token: String = "b6d85daeac7547729536242bed22459a"): Single<Packet>
}