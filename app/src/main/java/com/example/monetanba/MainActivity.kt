package com.example.monetanba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.monetanba.ui.navigation.Screen
import com.example.monetanba.ui.playerdetail.PlayerDetailScreen
import com.example.monetanba.ui.playerdetail.PlayerDetailViewModel
import com.example.monetanba.ui.playerlist.PlayerListScreen
import com.example.monetanba.ui.playerlist.PlayerListViewModel
import com.example.monetanba.ui.teamdetail.TeamDetailScreen
import com.example.monetanba.ui.teamdetail.TeamDetailViewModel
import com.example.monetanba.ui.theme.MonetaNbaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MonetaNbaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier.fillMaxSize().padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        val navController = rememberNavController()

                        NavHost(
                            navController = navController,
                            startDestination = Screen.PlayerList.route,
                            enterTransition = {
                                slideIntoContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Start,
                                    animationSpec = tween(400)
                                ) + fadeIn(animationSpec = tween(400))
                            },
                            exitTransition = {
                                slideOutOfContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Start  ,
                                    animationSpec = tween(400)
                                ) + fadeOut(animationSpec = tween(400))
                            },
                            popEnterTransition = {
                                slideIntoContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.End,
                                    animationSpec = tween(400)
                                ) + fadeIn(animationSpec = tween(400))
                            },
                            popExitTransition = {
                                slideOutOfContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.End,
                                    animationSpec = tween(400)
                                ) + fadeOut(animationSpec = tween(400))
                            }
                        ) {
                            composable(route = Screen.PlayerList.route) {
                                val viewModel: PlayerListViewModel = hiltViewModel()
                                PlayerListScreen(
                                    viewModel = viewModel,
                                    onNavigateToDetail = { playerId ->
                                        navController.navigate(Screen.PlayerDetail.createRoute(playerId))
                                    }
                                )
                            }

                            composable(
                                route = Screen.PlayerDetail.route,
                                arguments = listOf(navArgument("playerId") { type = NavType.IntType })
                            ) {
                                val viewModel: PlayerDetailViewModel = hiltViewModel()
                                PlayerDetailScreen(
                                    viewModel = viewModel,
                                    onNavigateToTeam = { teamId ->
                                        navController.navigate(Screen.TeamDetail.createRoute(teamId))
                                    }
                                )
                            }

                            composable(
                                route = Screen.TeamDetail.route,
                                arguments = listOf(navArgument("teamId") { type = NavType.IntType })
                            ) {
                                val viewModel: TeamDetailViewModel = hiltViewModel()
                                TeamDetailScreen(viewModel = viewModel)
                            }
                        }
                    }
                }
            }
        }
    }
}