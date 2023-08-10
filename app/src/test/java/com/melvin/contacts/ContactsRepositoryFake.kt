package com.melvin.contacts

import com.melvin.contacts.core.domain.Contact
import com.melvin.contacts.core.domain.ContactsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ContactsRepositoryFake : ContactsRepository {

    override suspend fun insertContact(contact: Contact) {

    }

    override suspend fun updateContact(contact: Contact) {

    }

    override fun getAllContacts(): Flow<List<Contact>> =
        flow { emit(allContacts()) }

    override suspend fun getContactByKey(key: String): Contact =
        contact()
}

fun contact() = Contact(
    firstName = "Melvin",
    lastName = "Kucuk",
    companyName = "Right Balance",
    address = "Fake Street 123",
    city = "Fake Street 123",
    county = "Argentina",
    state = "Buenos Aires",
    zip = "1333",
    phone = "11432343",
    phone1 = "112345678",
    email = "mkucuk@gmail.com",
)

fun allContacts() = listOf(contact())
