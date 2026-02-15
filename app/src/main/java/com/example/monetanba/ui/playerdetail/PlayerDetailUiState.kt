package com.example.monetanba.ui.playerdetail

import com.example.monetanba.data.domain.model.Player

data class PlayerDetailUiState(
    val isLoading: Boolean = false,
    val player: Player? = null,
    val error: String? = null
)