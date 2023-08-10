package com.melvin.contacts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.melvin.contacts.detail.presentation.ContactDetailScreen
import com.melvin.contacts.detail.presentation.viewmodel.ContactDetailEvent
import com.melvin.contacts.detail.presentation.viewmodel.ContactDetailViewModel
import com.melvin.contacts.home.presentation.HomeScreen
import com.melvin.contacts.home.presentation.viewmodel.HomeEvent
import com.melvin.contacts.home.presentation.viewmodel.HomeViewModel

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Routes.HomeScreen.route) {
        composable(Routes.HomeScreen.route) {
            val viewModel: HomeViewModel = hiltViewModel()

            LaunchedEffect(viewModel.state.navigateToDetail) {
                val contactKey = viewModel.state.navigateToDetail
                if (contactKey != null) {
                    navController.navigate(Routes.DetailScreen.getDestination(contactKey))
                    viewModel.onEvent(HomeEvent.DetailNavigated)
                }
            }

            HomeScreen(viewModel.state, viewModel::onEvent)
        }
        composable(
            route = Routes.DetailScreen.getCompleteRoute(),
            arguments = listOf(
                navArgument(Routes.DetailScreen.CONTACT_KEY) {
                    type = NavType.StringType
                }
            )
        ) {
            val viewModel: ContactDetailViewModel = hiltViewModel()

            LaunchedEffect(viewModel.state.navigateBack) {
                if (viewModel.state.navigateBack  == true) {
                    navController.popBackStack()
                    viewModel.onEvent(ContactDetailEvent.BackNavigated)
                }
            }

            ContactDetailScreen(viewModel.state, viewModel::onEvent)
        }
    }
}