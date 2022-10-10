package com.example.mfpa.Module

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mfpa.Database.AnimeDatabase
import com.example.mfpa.Database.AnimeQuoteRepository
import com.example.mfpa.Database.AnimeQuoteRepositoryList
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

    fun provideAnimeQuotesDatabase (application: Application): RoomDatabase.Builder<AnimeDatabase> {
        return Room.databaseBuilder(
            application,
            AnimeDatabase::class.java,
            "animeDatabase"
        )

    }

    //val animeDatabase = AnimeDatabase.animeData()

    @Provides
    @Singleton

    fun provideAnimeQuotesRepository (database: AnimeDatabase): AnimeQuoteRepository{

        return AnimeQuoteRepositoryList(database.animeQuotesDao)
    }
}