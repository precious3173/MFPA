package com.example.mfpa.Database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [AnimeQuoteEntity::class], version = 1)
abstract class AnimeDatabase : RoomDatabase() {

 abstract fun animeQuotesDao(): AnimeQuotesDao

 
}