package com.example.monetanba.data.domain.repository

import com.example.monetanba.data.domain.model.Player
import com.example.monetanba.data.domain.model.Team

interface NbaRepository {
    suspend fun getPlayers(cursor: Int?): Result<Pair<List<Player>, Int?>>

    suspend fun getPlayerById(id: Int): Result<Player>

    suspend fun getTeamById(id: Int): Result<Team>
}