package com.example.mfpa.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [AnimeQuoteEntity::class], version = 1)
abstract class AnimeDatabase : RoomDatabase() {

 abstract val animeQuotesDao: AnimeQuotesDao

 companion object{

@Volatile
 private var ANIMEINSTANCE : AnimeDatabase? = null

fun animeData (context: Context): AnimeDatabase? {

    synchronized(this){
      var animeInst:AnimeDatabase? = ANIMEINSTANCE
    if (animeInst == null){
     animeInst = Room.databaseBuilder<AnimeDatabase>(context.applicationContext,
      AnimeDatabase::class.java, "Anime_Database").build()
    }
        return animeInst
  }


 }
}
}