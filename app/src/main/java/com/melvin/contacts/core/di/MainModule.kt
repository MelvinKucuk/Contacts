package com.melvin.contacts.core.di

import android.content.Context
import com.melvin.contacts.core.domain.FileReader
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MainModule {

    @Provides
    fun providesFileReader(@ApplicationContext context: Context): FileReader =
        FileReader(context)

}
