package ru.sergey1057.home.dto

import com.google.gson.annotations.SerializedName

data class Table(

    @SerializedName("position")
    val position: Integer,
    @SerializedName("team")
    val team: Team,
    @SerializedName("playedGames")
    val playedGames: Integer,
    @SerializedName("form")
    val form: String?,
    @SerializedName("won")
    val won: Integer,
    @SerializedName("draw")
    val draw: Integer,
    @SerializedName("lost")
    val lost: Integer,
    @SerializedName("points")
    val points: Integer,
    @SerializedName("goalsFor")
    val goalsFor: Integer,
    @SerializedName("goalsAgainst")
    val goalsAgainst: Integer,
    @SerializedName("goalDifference")
    val goalDifference: Integer,

    )
