package com.example.monetanba.data.domain.model

data class Team(
    val id: Int,
    val fullName: String,
    val name: String,
    val abbreviation: String,
    val city: String,
    val conference: String,
    val division: String,
    val imageUrl: String
)

