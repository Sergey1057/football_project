package ru.sergey1057.scorers.dto

import com.google.gson.annotations.SerializedName

data class Scorers(

    @SerializedName("player")
    val player: Player,
    @SerializedName("team")
    val team: Team,
    @SerializedName("numberOfGoals")
    val numberOfGoals: Int,
)
