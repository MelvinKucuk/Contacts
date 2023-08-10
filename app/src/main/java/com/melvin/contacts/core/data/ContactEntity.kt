package com.melvin.contacts.core.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ContactEntity(
    @PrimaryKey
    val key: String,
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
)
