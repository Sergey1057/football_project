package ru.sergey1057.home.dto

import com.google.gson.annotations.SerializedName

data class Standing(

    @SerializedName("stage")
    val stage: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("group")
    val group: String?,
    @SerializedName("table")
    val table: List<Table>

)
