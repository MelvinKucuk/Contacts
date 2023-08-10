package com.melvin.contacts

import com.melvin.contacts.core.domain.ContactsRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class ContactsRepositoryTest {

    private lateinit var contactsRepository: ContactsRepository

    @Before
    fun setUp() {
        contactsRepository = ContactsRepositoryFake()
    }

    @Test
    fun `get contact by id working as expected`() = runBlocking {
        val expectedResult = contact()

        val result = contactsRepository.getContactByKey("")

        assertEquals(expectedResult, result)
    }

    @Test
    fun `get all contacts working as expected`() = runBlocking {
        val expectedResult = allContacts()

        val result = contactsRepository.getAllContacts().first()

        assertEquals(expectedResult, result)
    }
}