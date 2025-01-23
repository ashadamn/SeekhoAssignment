package com.example.seekhoassignment.presentation.ui.screens.anime_detail_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.seekhoassignment.data.model.anime_detail_response.AnimeDetailResponseDTO
import com.example.seekhoassignment.domain.util.ApiResult
import com.example.seekhoassignment.presentation.theme.Spacing
import com.example.seekhoassignment.presentation.ui.screens.anime_detail_screen.components.YouTubeVideoPlayer
import com.example.seekhoassignment.presentation.util.AppNetworkImage
import com.example.seekhoassignment.presentation.util.UiStateHandler

@Composable
fun AnimeDetailScreen(
    state: ApiResult<AnimeDetailResponseDTO>
) {

    Scaffold(
        content = { paddingValues ->
            UiStateHandler(
                uiState = state,
                onSuccess = { animeDetail ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(Spacing.small)
                    ) {

                        if (animeDetail.data?.trailer?.url != null) {
                            YouTubeVideoPlayer(
                                url = animeDetail.data?.trailer?.url!!,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                            )
                        } else {
                            AppNetworkImage(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp),
                                model = animeDetail.data?.images?.jpg?.largeImageUrl
                            )
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = Spacing.medium),
                            verticalArrangement = Arrangement.spacedBy(Spacing.small)
                        ) {
                            Text(
                                text = animeDetail.data?.title ?: animeDetail.data?.titleEnglish
                                ?: animeDetail.data?.titleJapanese ?: "Null",
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.titleLarge
                            )

                            Row {
                                Text(
                                    text = "Number of Episodes - ",
                                    fontWeight = FontWeight.Bold,
                                    style = MaterialTheme.typography.titleMedium
                                )

                                Text(
                                    text = animeDetail.data?.episodes.toString(),
                                    style = MaterialTheme.typography.titleMedium
                                )
                            }

                            Row {
                                Text(
                                    text = "Score - ",
                                    fontWeight = FontWeight.Bold,
                                    style = MaterialTheme.typography.titleMedium
                                )

                                Text(
                                    text = animeDetail.data?.score.toString(),
                                    style = MaterialTheme.typography.titleMedium
                                )
                            }

                            animeDetail.data?.genres?.map { it.name ?: "Null" }
                                ?.let { genreList ->
                                    Row {
                                        Text(
                                            text = "Genres - ",
                                            fontWeight = FontWeight.Bold,
                                            style = MaterialTheme.typography.titleMedium
                                        )


                                        Text(
                                            text = genreList.joinToString(", "),
                                            style = MaterialTheme.typography.titleMedium
                                        )
                                    }
                                }

                            Text(
                                text = "Synopsis -",
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Text(
                                text = animeDetail.data?.synopsis ?: "Null",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }

                    }
                }
            )
        }
    )

}