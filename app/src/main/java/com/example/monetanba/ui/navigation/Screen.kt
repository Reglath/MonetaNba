package com.example.monetanba.ui.navigation

sealed class Screen(val route: String) {
    object PlayerList : Screen("player_list")
    object PlayerDetail : Screen("player_detail/{playerId}") {
        fun createRoute(playerId: Int) = "player_detail/$playerId"
    }
    object TeamDetail : Screen("team_detail/{teamId}") {
        fun createRoute(teamId: Int) = "team_detail/$teamId"
    }
}