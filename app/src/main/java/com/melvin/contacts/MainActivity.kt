package com.melvin.contacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.melvin.contacts.core.presentation.MainViewModel
import com.melvin.contacts.ui.theme.ContactsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MainViewModel by viewModels()

        installSplashScreen().setKeepOnScreenCondition {
            viewModel.state.isLoading
        }

        setContent {
            if (!viewModel.state.isLoading) {
                ContactsTheme {
                    val navController = rememberNavController()
                    Navigation(navController = navController)
                }
            }
        }
    }
}