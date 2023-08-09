package com.melvin.contacts

sealed class Routes(val route: String) {
    object HomeScreen: Routes("home_screen")
}
