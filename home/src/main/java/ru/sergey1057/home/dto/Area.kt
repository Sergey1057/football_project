package ru.sergey1057.home.dto

import com.google.gson.annotations.SerializedName

data class Area(
    @SerializedName("id")
    val id: Integer,
    @SerializedName("name")
    val name: String,
)



