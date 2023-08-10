package com.melvin.contacts.detail.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.contacts.Routes
import com.melvin.contacts.core.domain.Contact
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
                    contactKey = safeContactKey
                )
            }
        }
    }

    fun onEvent(event: ContactDetailEvent) {
        state = when (event) {
            is ContactDetailEvent.AddressTextChanged -> {
                state.copy(
                    addressText = event.text
                )
            }

            is ContactDetailEvent.CityTextChanged -> {
                state.copy(
                    cityText = event.text
                )
            }

            is ContactDetailEvent.CompanyNameTextChanged -> {
                state.copy(
                    companyNameText = event.text
                )
            }

            is ContactDetailEvent.CountyTextChanged -> {
                state.copy(
                    countyText = event.text
                )
            }

            is ContactDetailEvent.EmailTextChanged -> {
                state.copy(
                    emailText = event.text
                )
            }

            is ContactDetailEvent.FirstNameTextChanged -> {
                state.copy(
                    firstNameText = event.text
                )
            }

            is ContactDetailEvent.LastNameTextChanged -> {
                state.copy(
                    lastNameText = event.text
                )
            }

            is ContactDetailEvent.Phone1TextChanged -> {
                state.copy(
                    phone1Text = event.text
                )
            }

            is ContactDetailEvent.PhoneTextChanged -> {
                state.copy(
                    phoneText = event.text
                )
            }

            is ContactDetailEvent.StateTextChanged -> {
                state.copy(
                    stateText = event.text
                )
            }

            is ContactDetailEvent.ZipTextChanged -> {
                state.copy(
                    zipText = event.text
                )
            }

            ContactDetailEvent.SaveButtonClicked -> {
                viewModelScope.launch {
                    val updatedContact =
                        Contact(
                            firstName = state.firstNameText,
                            lastName = state.lastNameText,
                            companyName = state.companyNameText,
                            address = state.addressText,
                            city = state.cityText,
                            county = state.countyText,
                            state = state.stateText,
                            zip = state.zipText,
                            phone = state.phoneText,
                            phone1 = state.phone1Text,
                            email = state.emailText,
                            key = state.contactKey,
                        )
                    contactsRepository.updateContact(updatedContact)
                }
                state.copy(navigateBack = true)
            }

            ContactDetailEvent.BackNavigated -> {
                state.copy(navigateBack = null)
            }
        }
    }
}