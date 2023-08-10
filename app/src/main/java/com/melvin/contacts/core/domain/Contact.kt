package com.melvin.contacts.core.domain

data class Contact(
    val key: String = "",
    val firstName: String,
    val lastName: String,
    val companyName: String,
    val address: String,
    val city: String,
    val county: String,
    val state: String,
    val zip: String,
    val phone: String,
    val phone1: String,
    val email: String,
) {
    val fullName get() = "$firstName $lastName"
    val initials get() = getInitials(fullName)
}
