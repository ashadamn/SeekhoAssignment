package com.example.seekhoassignment.data.repository

import com.example.seekhoassignment.data.model.anime_detail_response.AnimeDetailResponseDTO
import com.example.seekhoassignment.data.model.top_anime_response.TopAnimeResponseDTO
import com.example.seekhoassignment.data.source.remote.AppApiService
import com.example.seekhoassignment.data.util.ResponseState
import com.example.seekhoassignment.data.util.getApiResponseState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AnimeRepositoryImpl(private val apiService: AppApiService) : AnimeRepository {
    override suspend fun getTopAnime(): ResponseState<TopAnimeResponseDTO> {
        return getApiResponseState {
            withContext(Dispatchers.IO) {
                apiService.getTopAnime()
            }
        }
    }

    override suspend fun getAnimeDetail(animeId: Int): ResponseState<AnimeDetailResponseDTO> {
        return getApiResponseState {
            withContext(Dispatchers.IO) {
                apiService.getAnimeDetail(animeId)
            }
        }
    }
}