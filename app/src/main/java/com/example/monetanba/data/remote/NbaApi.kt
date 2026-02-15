package com.example.monetanba.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NbaApi {
    companion object {
        const val BASE_URL = "https://api.balldontlie.io/v1/"
    }

    @GET("players")
    suspend fun getPlayers(
        @Query("cursor") cursor: Int? = null,
        @Query("per_page") perPage: Int = 35
    ): PlayerListResponse

    @GET("players/{id}")
    suspend fun getPlayerDetail(
        @Path("id") playerId: Int
    ): PlayerDetailResponse

    @GET("teams/{id}")
    suspend fun getTeamDetail(
        @Path("id") teamId: Int
    ): TeamDetailResponse
}