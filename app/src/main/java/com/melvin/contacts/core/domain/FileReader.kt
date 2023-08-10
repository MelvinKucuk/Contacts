package com.melvin.contacts.core.domain

import android.content.Context
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.BufferedReader
import javax.inject.Inject

class FileReader @Inject constructor(
    private val context: Context,
    private val contactsRepository: ContactsRepository
) {

    suspend fun readFileAndCreateDB() {
        if (contactsRepository.getAllContacts().first().isNotEmpty())
            return

        val reader = BufferedReader(context.assets.open(FILE_NAME).reader())
        val csvReader = CSVParser.parse(
            reader,
            CSVFormat.DEFAULT
        )

        coroutineScope {
                csvReader.drop(1).map { record ->
                    launch {
                        record?.let { safeRecord ->
                            val contact = Contact(
                                firstName = safeRecord[0],
                                lastName = safeRecord[1],
                                companyName = safeRecord[2],
                                address = safeRecord[3],
                                city = safeRecord[4],
                                country = safeRecord[5],
                                state = safeRecord[6],
                                zip = safeRecord[7],
                                phone = safeRecord[8],
                                phone1 = safeRecord[9],
                                email = safeRecord[10],
                            )
                            contactsRepository.insertContact(contact)
                        }
                    }
                }.map { it.join() }
        }
    }

    companion object {
        private const val FILE_NAME = "sample_contacts.csv"
    }
}