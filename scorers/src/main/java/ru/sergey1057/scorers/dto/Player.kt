package ru.sergey1057.scorers.dto

import com.google.gson.annotations.SerializedName

data class Player(

    @SerializedName("id")
    val id: Integer,

    @SerializedName("name")
    val name: String,
    @SerializedName("firstName")

    val firstName: String,

    @SerializedName("lastName")

    val lastName: String,

    @SerializedName("nationality")

    val nationality: String,
)
