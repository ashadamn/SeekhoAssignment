package com.example.seekhoassignment.presentation.ui.screens.anime_detail_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seekhoassignment.data.model.anime_detail_response.AnimeDetailResponseDTO
import com.example.seekhoassignment.data.repository.AnimeRepository
import com.example.seekhoassignment.domain.util.ApiResult
import com.example.seekhoassignment.domain.util.toApiResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AnimeDetailViewModel(
    private val repository: AnimeRepository
) : ViewModel() {

    private val _animeDetailState =
        MutableStateFlow<ApiResult<AnimeDetailResponseDTO>>(ApiResult.Loading)
    val animeDetailState: StateFlow<ApiResult<AnimeDetailResponseDTO>> =
        _animeDetailState.asStateFlow()


    fun loadAnimeDetail(animeId: Int) {
        _animeDetailState.value = ApiResult.Loading
        viewModelScope.launch {
            val response = repository.getAnimeDetail(animeId)
            _animeDetailState.value = response.toApiResult()
        }
    }

}