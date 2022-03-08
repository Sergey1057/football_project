package ru.sergey1057.scorers.dto

import com.google.gson.annotations.SerializedName

data class Player(

    @SerializedName("id")
    val id: Integer,

    @SerializedName("name")
    val  name: String,
    @SerializedName("firstName")

val firstName: String ,

@SerializedName("lastName")

val lastName: String ,

//@SerializedName("dateOfBirth")
//
//val String dateOfBirth,
//
//@SerializedName("countryOfBirth")
//
//val String countryOfBirth,

@SerializedName("nationality")

val nationality: String ,

//@SerializedName("position")

//val String position,
//
//@SerializedName("shirtNumber")
//
//val Integer shirtNumber,
//
//@SerializedName("lastUpdated")
//
//val String lastUpdated
)
