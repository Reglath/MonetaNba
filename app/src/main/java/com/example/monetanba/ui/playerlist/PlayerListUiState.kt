package com.example.monetanba.ui.playerlist

import com.example.monetanba.data.domain.model.Player

/**
 * Reprezentuje stav uživatelského rozhraní pro obrazovku seznamu hráčů.
 */
data class PlayerListUiState(
    val isLoading: Boolean = false,
    val players: List<Player> = emptyList(),
    val error: String? = null,
    val endReached: Boolean = false
)