package ru.sergey1057.world.dto

import com.google.gson.annotations.SerializedName

data class WorldPacket (

    @SerializedName("seasons")
    val seasons: List<Seasons>
)