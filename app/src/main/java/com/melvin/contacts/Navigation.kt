package com.melvin.contacts

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.melvin.contacts.home.presentation.HomeScreen
import com.melvin.contacts.home.presentation.HomeViewModel

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Routes.HomeScreen.route) {
        composable(Routes.HomeScreen.route) {
            val viewModel: HomeViewModel = hiltViewModel()

            HomeScreen()
        }
    }
}