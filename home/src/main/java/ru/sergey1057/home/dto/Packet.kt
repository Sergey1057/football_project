package ru.sergey1057.home.dto
import com.google.gson.annotations.SerializedName


data class Packet (

    @SerializedName("competition")
    val competition: Competition,

    @SerializedName("season")
    val season: Season,

    @SerializedName("standings")
    val standings: List<Standing>
)