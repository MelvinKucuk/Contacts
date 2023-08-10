package com.melvin.contacts.detail.presentation.viewmodel

sealed class ContactDetailEvent {
    data class FirstNameTextChanged(val text: String): ContactDetailEvent()
    data class LastNameTextChanged(val text: String): ContactDetailEvent()
    data class CompanyNameTextChanged(val text: String): ContactDetailEvent()
    data class AddressTextChanged(val text: String): ContactDetailEvent()
    data class CityTextChanged(val text: String): ContactDetailEvent()
    data class CountyTextChanged(val text: String): ContactDetailEvent()
    data class StateTextChanged(val text: String): ContactDetailEvent()
    data class ZipTextChanged(val text: String): ContactDetailEvent()
    data class PhoneTextChanged(val text: String): ContactDetailEvent()
    data class Phone1TextChanged(val text: String): ContactDetailEvent()
    data class EmailTextChanged(val text: String): ContactDetailEvent()
    object SaveButtonClicked: ContactDetailEvent()
    object BackNavigated: ContactDetailEvent()
}
