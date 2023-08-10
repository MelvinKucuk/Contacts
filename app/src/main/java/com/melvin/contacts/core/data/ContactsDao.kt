package com.melvin.contacts.core.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactsDao {
    @Upsert
    suspend fun insertContact(contact: ContactEntity)

    @Query("SELECT * FROM ContactEntity")
    fun getAllContacts(): Flow<List<ContactEntity>>

    @Query("SELECT * FROM ContactEntity WHERE `key` = :key")
    suspend fun getContactByKey(key: String): ContactEntity
}