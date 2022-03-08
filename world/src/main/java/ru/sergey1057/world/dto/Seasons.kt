package ru.sergey1057.world.dto

import com.google.gson.annotations.SerializedName

data class Seasons(
    @SerializedName("startDate")
    val startDate: String,
    @SerializedName("winner")
    val winner: Winner,
)
