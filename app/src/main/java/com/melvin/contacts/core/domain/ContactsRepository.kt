package com.melvin.contacts.core.domain

import kotlinx.coroutines.flow.Flow

interface ContactsRepository {
    suspend fun insertContact(contact: Contact)
    suspend fun updateContact(contact: Contact)
    fun getAllContacts(): Flow<List<Contact>>
    suspend fun getContactByKey(key: String): Contact
}