package com.example.mfpa.module

import android.app.Application
import androidx.room.Room
import com.example.mfpa.Database.AnimeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Volatile
    private var INSTANCE: AnimeDatabase? = null

    @Singleton
    @Provides
    fun getDatabase(
        app:Application
    ): AnimeDatabase{

        val tempInstant = INSTANCE

        if(tempInstant != null) return tempInstant

        synchronized(this){
            val instance = Room.databaseBuilder(app.applicationContext,
              AnimeDatabase::class.java,
                "Anime_Database"
                ).allowMainThreadQueries().build()

            INSTANCE = instance
            return instance
        }



    }
}