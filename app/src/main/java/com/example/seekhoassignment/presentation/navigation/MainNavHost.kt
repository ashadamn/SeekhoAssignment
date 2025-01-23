package com.example.seekhoassignment.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.seekhoassignment.domain.util.ApiResult
import com.example.seekhoassignment.presentation.ui.screens.anime_detail_screen.AnimeDetailScreen
import com.example.seekhoassignment.presentation.ui.screens.anime_detail_screen.AnimeDetailViewModel
import com.example.seekhoassignment.presentation.ui.screens.home_screen.HomeScreen
import com.example.seekhoassignment.presentation.ui.screens.home_screen.HomeViewModel
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun MainNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = AppNavigation.Home.route
) {

    NavHost(navController = navController, startDestination = startDestination) {
        composable(AppNavigation.Home.route) {
            val homeViewModel: HomeViewModel = koinViewModel()
            val animeListState by homeViewModel.animeListState.collectAsStateWithLifecycle()
            HomeScreen(
                state = animeListState,
                onClick = { id ->
                    navController.navigate(AppNavigation.AnimeDetail.createRoute(id))
                }
            )
        }

        composable(AppNavigation.AnimeDetail.route) { backStackEntry ->
            val animeId = (backStackEntry.arguments?.getString(AppNavigation.ANIME_ID_ARG)
                ?: "0").toIntOrNull() ?: -1

            val animeDetailViewModel: AnimeDetailViewModel = koinViewModel()
            val uiState by animeDetailViewModel.animeDetailState.collectAsStateWithLifecycle()

            LaunchedEffect(Unit) {
                if (uiState !is ApiResult.Success) {
                    animeDetailViewModel.loadAnimeDetail(animeId)
                }
            }

            AnimeDetailScreen(
                state = uiState
            )

        }
    }
}
