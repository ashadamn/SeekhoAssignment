package com.example.seekhoassignment.data.repository

import com.example.seekhoassignment.data.model.anime_detail_response.AnimeDetailResponseDTO
import com.example.seekhoassignment.data.model.top_anime_response.TopAnimeResponseDTO
import com.example.seekhoassignment.data.util.ResponseState

interface AnimeRepository {

    suspend fun getTopAnime(): ResponseState<TopAnimeResponseDTO>

    suspend fun getAnimeDetail(animeId: Int): ResponseState<AnimeDetailResponseDTO>

}