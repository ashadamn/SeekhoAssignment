package com.example.seekhoassignment.presentation.ui.screens.home_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.seekhoassignment.data.model.top_anime_response.Data
import com.example.seekhoassignment.presentation.theme.Spacing
import com.example.seekhoassignment.presentation.util.AppNetworkImage

@Composable
fun AnimeItem(
    anime: Data,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Spacing.medium)
            .height(100.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = Spacing.small),
        onClick = { onClick() }
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
        ) {

            AppNetworkImage(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(100.dp)
                    .clip(RoundedCornerShape(Spacing.medium)),
                model = anime.images?.jpg?.imageUrl
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = Spacing.medium),
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = anime.title ?: anime.titleEnglish ?: anime.titleJapanese ?: "null",
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    modifier = Modifier
                        .padding(vertical = Spacing.small),
                    text = "Episodes - ${anime.episodes.toString()}",
                    style = MaterialTheme.typography.titleSmall
                )
                Text(
                    text = "Score - ${anime.score.toString()}",
                    style = MaterialTheme.typography.titleSmall
                )

            }
        }

    }

}