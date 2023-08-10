package com.melvin.contacts.home.presentation.viewmodel

sealed class HomeEvent {
    data class ContactClicked(val contactKey: String): HomeEvent()
    object DetailNavigated: HomeEvent()
}
