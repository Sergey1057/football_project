package ru.sergey1057.world.dto

import com.google.gson.annotations.SerializedName

data class Winner(
    @SerializedName("name")
    val name: String,

)
