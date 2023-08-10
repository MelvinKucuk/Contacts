package com.melvin.contacts

import androidx.lifecycle.SavedStateHandle
import com.melvin.contacts.core.domain.ContactsRepository
import com.melvin.contacts.detail.presentation.viewmodel.ContactDetailEvent
import com.melvin.contacts.detail.presentation.viewmodel.ContactDetailViewModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ContactDetailViewModelTest {

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private lateinit var viewModel: ContactDetailViewModel

    private val savedStateHandle: SavedStateHandle = mockk()

    private val contactsRepository: ContactsRepository = mockk()

    @Before
    fun setUp() {
        every { savedStateHandle.get<String>(any()) } returns null

        viewModel = ContactDetailViewModel(
            contactsRepository = contactsRepository,
            savedStateHandle = savedStateHandle
        )
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `verify that update contact is called when save button event is triggered`() {
        coEvery { contactsRepository.updateContact(any()) } just runs

        viewModel.onEvent(ContactDetailEvent.SaveButtonClicked)

        coroutineRule.dispatcher.scheduler.advanceUntilIdle()

        coVerify(exactly = 1) { contactsRepository.updateContact(any()) }
    }
}