package com.melvin.contacts.core.data

import com.melvin.contacts.core.domain.Contact
import com.melvin.contacts.core.domain.ContactsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.UUID
import javax.inject.Inject

class ContactsRepositoryImpl @Inject constructor(
    private val contactsDao: ContactsDao
): ContactsRepository {

    override suspend fun insertContact(contact: Contact) {
        contactsDao.insertContact(contact.toEntity(UUID.randomUUID().toString()))
    }

    override suspend fun updateContact(contact: Contact) {
        contactsDao.insertContact(contact.toEntity())
    }

    override fun getAllContacts(): Flow<List<Contact>> {
        return contactsDao.getAllContacts()
            .map { list -> list.map { it.toDomain() } }
    }
}