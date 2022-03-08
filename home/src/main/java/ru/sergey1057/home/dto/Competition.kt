package ru.sergey1057.home.dto

import com.google.gson.annotations.SerializedName

data class Competition(

    @SerializedName("id")
    val id: Integer,
    @SerializedName("area")
    val area: Area,
    @SerializedName("name")
    val name: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("plan")
    val plan: String,
    @SerializedName("lastUpdated")
    val lastUpdated: String ,
    
)
