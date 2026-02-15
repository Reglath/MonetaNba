package com.example.monetanba.ui.teamdetail

import com.example.monetanba.data.domain.model.Team

/**
 * Reprezentuje stav uživatelského rozhraní pro obrazovku detailu teamu.
 */
data class TeamDetailUiState(
    val isLoading: Boolean = false,
    val team: Team? = null,
    val error: String? = null
)