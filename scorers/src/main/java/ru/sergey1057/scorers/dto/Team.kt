package ru.sergey1057.scorers.dto

import com.google.gson.annotations.SerializedName

data class Team(

    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,


)
