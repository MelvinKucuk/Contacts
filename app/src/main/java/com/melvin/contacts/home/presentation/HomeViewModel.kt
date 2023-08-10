package com.melvin.contacts.home.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.contacts.core.domain.ContactsRepository
import com.melvin.contacts.core.domain.FileReader
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fileReader: FileReader,
    private val contactsRepository: ContactsRepository
): ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    init {
        viewModelScope.launch {
            fileReader.readFileAndCreateDB()
            contactsRepository.getAllContacts().distinctUntilChanged().collectLatest {
                state = state.copy(contacts = it)
            }
        }
    }
}