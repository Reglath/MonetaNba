package com.example.monetanba.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MetaDto(
    @SerializedName("next_cursor") val nextCursor: Int?,
    @SerializedName("per_page") val perPage: Int
)