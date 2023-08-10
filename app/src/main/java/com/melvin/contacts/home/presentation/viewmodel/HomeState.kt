package com.melvin.contacts.home.presentation.viewmodel

import com.melvin.contacts.core.domain.Contact

data class HomeState(
    val contacts: List<Contact> = listOf(),
    val navigateToDetail: String? = null
)
