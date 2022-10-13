package com.example.mfpa.Module

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
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
object AppModule {

    @Provides
    @Singleton
    fun provideAnimeQuotesDatabase (application: Application): AnimeDatabase {
        return Room.databaseBuilder(
            application,
            AnimeDatabase::class.java,
            "animeDatabase"
        ).build()

    }


    @Provides
    fun provideAnimeQuotesRepository (database: AnimeDatabase): AnimeQuoteRepository {

        return AnimeQuoteRepositoryList(database.animeQuotesDao)
    }
}