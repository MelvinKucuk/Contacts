package com.melvin.contacts.core.di

import android.content.Context
import androidx.room.Room
import com.melvin.contacts.core.data.ContactDatabase
import com.melvin.contacts.core.data.ContactsDao
import com.melvin.contacts.core.data.ContactsRepositoryImpl
import com.melvin.contacts.core.domain.ContactsRepository
import com.melvin.contacts.core.domain.FileReader
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MainModule {

    @Provides
    fun providesFileReader(
        @ApplicationContext context: Context,
        contactsRepository: ContactsRepository
    ): FileReader =
        FileReader(
            context = context,
            contactsRepository = contactsRepository
        )

    @Provides
    @Singleton
    fun providesContactDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context = context,
            klass = ContactDatabase::class.java,
            name = "contacts_db"
        ).build()

    @Provides
    @Singleton
    fun providesContactsDao(contactDatabase: ContactDatabase): ContactsDao = contactDatabase.dao

}

@Module
@InstallIn(SingletonComponent::class)
abstract class MainBindsModule {

    @Binds
    abstract fun providesContactsRepository(repository: ContactsRepositoryImpl): ContactsRepository

}
