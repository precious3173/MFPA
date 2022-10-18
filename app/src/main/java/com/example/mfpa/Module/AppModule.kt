package com.example.mfpa.Module

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mfpa.Database.AnimeDatabase
import com.example.mfpa.Database.AnimeQuoteEntity
import com.example.mfpa.Database.Repository.AnimeQuoteRepository
import com.example.mfpa.Database.Repository.AnimeQuoteRepositoryList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAnimeQuotesDatabase (
        application: Application,
        animeCallback: AnimeDatabase.AnimeCallback
    ) =
         Room.databaseBuilder(
            application,
            AnimeDatabase::class.java,
            "animeDatabase"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().
         addCallback(animeCallback).build()




    @Provides
    fun provideAnimeQuoteDao (database: AnimeDatabase) = database.animeQuotesDao()

    @CoroutineSco
    @Provides
    @Singleton
    fun providesCoroutineScope() = CoroutineScope(SupervisorJob())

    @Retention(AnnotationRetention.RUNTIME)
    @Qualifier
    annotation class CoroutineSco
}