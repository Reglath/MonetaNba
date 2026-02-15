package com.example.monetanba.data.remote.dto

import com.example.monetanba.data.domain.model.Team
import com.google.gson.annotations.SerializedName

data class TeamDto(
    @SerializedName("id") val id: Int,
    @SerializedName("conference") val conference: String?,
    @SerializedName("division") val division: String?,
    @SerializedName("city") val city: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("full_name") val fullName: String?,
    @SerializedName("abbreviation") val abbreviation: String?
)

fun TeamDto.toDomain(): Team {
    return Team(
        id = id,
        fullName = fullName ?: "Neznámý tým",
        name = name ?: "Neznámý tým",
        abbreviation = abbreviation ?: "???",
        city = city ?: "Neznámé město",
        conference = conference ?: "N/A",
        division = division ?: "N/A",
        imageUrl = "https://picsum.photos/seed/${this.id}/400"
    )
}