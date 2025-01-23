package com.example.seekhoassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.seekhoassignment.presentation.navigation.AppNavigation
import com.example.seekhoassignment.presentation.navigation.MainNavHost
import com.example.seekhoassignment.presentation.theme.SeekhoAssignmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val startDestination = AppNavigation.Home.route
            SeekhoAssignmentTheme {
                MainNavHost(startDestination = startDestination)
            }
        }
    }
}