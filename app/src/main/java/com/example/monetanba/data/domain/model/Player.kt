package com.example.monetanba.data.domain.model

data class Player(
    val id: Int,
    val name: String,
    val position: String,
    val height: String,
    val weight: String,
    val jerseyNumber: String,
    val college: String,
    val country: String,
    val draftInfo: String,
    val teamName: String,
    val teamId: Int,
    val imageUrl: String
)

