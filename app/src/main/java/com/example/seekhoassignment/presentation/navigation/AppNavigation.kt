package com.example.seekhoassignment.presentation.navigation

sealed class AppNavigation(val route: String) {
    companion object {
        const val ANIME_ID_ARG = "animeId"
    }

    data object Home : AppNavigation("home_screen")

    data object AnimeDetail : AppNavigation("anime_detail_screen/{$ANIME_ID_ARG}") {
        fun createRoute(animeId: Int) = "anime_detail_screen/$animeId"
    }
}