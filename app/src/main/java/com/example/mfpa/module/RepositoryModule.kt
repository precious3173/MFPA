package com.example.mfpa.module

import com.example.mfpa.Database.AnimeDatabase
import com.example.mfpa.Database.Repository.AnimeQuoteRepository
import com.example.mfpa.Database.Repository.AnimeQuoteRepositoryList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Singleton
    @Provides
    fun provideAnimeQuoteRepository (database: AnimeDatabase) : AnimeQuoteRepository
    {
        return AnimeQuoteRepositoryList(database)

    }
}