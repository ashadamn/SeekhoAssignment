package com.example.seekhoassignment.presentation.ui.screens.home_screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.seekhoassignment.data.model.top_anime_response.TopAnimeResponseDTO
import com.example.seekhoassignment.domain.util.ApiResult
import com.example.seekhoassignment.presentation.theme.Spacing
import com.example.seekhoassignment.presentation.ui.screens.home_screen.components.AnimeItem
import com.example.seekhoassignment.presentation.util.UiStateHandler

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    state: ApiResult<TopAnimeResponseDTO>,
    onClick: (animeId: Int) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Anime List") }
            )
        },
        content = { paddingValues ->
            UiStateHandler(
                uiState = state,
                onSuccess = { topAnimeList ->
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                        contentPadding = PaddingValues(Spacing.medium)
                    ) {
                        items(
                            topAnimeList.data
                        ) { anime ->
                            AnimeItem(
                                anime = anime,
                                onClick = { anime.malId?.let { onClick(it) } }
                            )
                        }
                    }
                }
            )
        }
    )
}