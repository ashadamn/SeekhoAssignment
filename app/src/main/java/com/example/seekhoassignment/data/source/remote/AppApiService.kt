package com.example.seekhoassignment.data.source.remote

import com.example.seekhoassignment.data.model.anime_detail_response.AnimeDetailResponseDTO
import com.example.seekhoassignment.data.model.top_anime_response.TopAnimeResponseDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class AppApiService(private val client: HttpClient) {

    suspend fun getTopAnime(): TopAnimeResponseDTO {
        return client.get("top/anime") {
        }.body()
    }

    suspend fun getAnimeDetail(animeId: Int): AnimeDetailResponseDTO {
        return client.get("anime/${animeId}") {
        }.body()
    }

}
