package com.melvin.contacts.home.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.contacts.core.domain.ContactsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val contactsRepository: ContactsRepository
): ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    init {
        viewModelScope.launch {
            contactsRepository.getAllContacts().distinctUntilChanged().collectLatest {
                state = state.copy(contacts = it)
            }
        }
    }

    fun onEvent(event: HomeEvent) {
        state = when (event) {
            is HomeEvent.ContactClicked -> {
                state.copy(navigateToDetail = event.contactKey)
            }

            HomeEvent.DetailNavigated -> {
                state.copy(navigateToDetail = null)
            }
        }
    }
}