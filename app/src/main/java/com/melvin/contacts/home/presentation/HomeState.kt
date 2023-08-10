package com.melvin.contacts.home.presentation

import com.melvin.contacts.core.domain.Contact

data class HomeState(
    val contacts: List<Contact> = listOf()
)
