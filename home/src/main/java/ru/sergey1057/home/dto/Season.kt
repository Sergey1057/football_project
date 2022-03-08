package ru.sergey1057.home.dto

import com.google.gson.annotations.SerializedName

data class Season(

    @SerializedName("id")
    val id: Integer,
    @SerializedName("startDate")
    val startDate: String,
    @SerializedName("endDate")
    val endDate: String,
    @SerializedName("currentMatchday")
    val currentMatchday: Integer,
    @SerializedName("winner")
    val winner: String


)
