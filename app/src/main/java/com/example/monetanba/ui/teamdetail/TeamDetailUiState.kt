package com.example.monetanba.ui.teamdetail

import com.example.monetanba.data.domain.model.Team

data class TeamDetailUiState(
    val isLoading: Boolean = false,
    val team: Team? = null,
    val error: String? = null
)