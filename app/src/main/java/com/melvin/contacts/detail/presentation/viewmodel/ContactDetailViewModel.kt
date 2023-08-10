package com.melvin.contacts.detail.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.contacts.Routes
import com.melvin.contacts.core.domain.ContactsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactDetailViewModel @Inject constructor(
    private val contactsRepository: ContactsRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var state by mutableStateOf(ContactDetailState())
        private set

    init {
        val contactKey = savedStateHandle.get<String>(Routes.DetailScreen.CONTACT_KEY)
        contactKey?.let { safeContactKey ->
            viewModelScope.launch {
                val contact = contactsRepository.getContactByKey(safeContactKey)
                state = state.copy(
                    firstNameText = contact.firstName,
                    lastNameText = contact.lastName,
                    companyNameText = contact.companyName,
                    addressText = contact.address,
                    cityText = contact.city,
                    countyText = contact.county,
                    stateText = contact.state,
                    zipText = contact.zip,
                    phoneText = contact.phone,
                    phone1Text = contact.phone1,
                    emailText = contact.email,
                )
            }
        }
    }
}