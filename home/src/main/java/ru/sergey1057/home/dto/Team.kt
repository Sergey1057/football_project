package ru.sergey1057.home.dto

import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("id")
    val id: Integer,
    @SerializedName("name")
    val name: String,
    @SerializedName("crestUrl")
    val crestUrl: String,

    )