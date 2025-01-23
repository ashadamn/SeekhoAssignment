package com.example.seekhoassignment.presentation.ui.screens.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seekhoassignment.data.model.top_anime_response.TopAnimeResponseDTO
import com.example.seekhoassignment.data.repository.AnimeRepository
import com.example.seekhoassignment.domain.util.ApiResult
import com.example.seekhoassignment.domain.util.toApiResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: AnimeRepository
) : ViewModel() {

    private val _animeListState =
        MutableStateFlow<ApiResult<TopAnimeResponseDTO>>(ApiResult.Loading)
    val animeListState: StateFlow<ApiResult<TopAnimeResponseDTO>> = _animeListState.asStateFlow()

    init {
        loadAnimeList()
    }

    private fun loadAnimeList() {
        _animeListState.value = ApiResult.Loading
        viewModelScope.launch {
            val response = repository.getTopAnime()
            _animeListState.value = response.toApiResult()
        }
    }

}