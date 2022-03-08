package ru.sergey1057.scorers.dto

import com.google.gson.annotations.SerializedName

data class ScorersPacket (

    @SerializedName("scorers")
    val scorers: List<Scorers>
)