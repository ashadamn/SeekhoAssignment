package com.example.seekhoassignment.di


import com.example.seekhoassignment.data.repository.AnimeRepository
import com.example.seekhoassignment.data.repository.AnimeRepositoryImpl
import com.example.seekhoassignment.data.source.remote.AppApiService
import com.example.seekhoassignment.di.NetworkProvider.provideHttpClient
import com.example.seekhoassignment.presentation.ui.screens.anime_detail_screen.AnimeDetailViewModel
import com.example.seekhoassignment.presentation.ui.screens.home_screen.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<AnimeRepository> { AnimeRepositoryImpl(get()) }
    single { AppApiService(get()) }
    single { provideHttpClient() }
    viewModel { HomeViewModel(get()) }
    viewModel { AnimeDetailViewModel(get()) }
}