package com.melvin.contacts

sealed class Routes(val route: String) {
    object HomeScreen: Routes("home_screen")
    object DetailScreen: Routes("detail_screen") {
        fun getCompleteRoute() = "$route?$CONTACT_KEY={$CONTACT_KEY}"
        fun getDestination(contactKey: String) = "$route?$CONTACT_KEY=$contactKey"

        const val CONTACT_KEY = "contact_key"

    }
}
