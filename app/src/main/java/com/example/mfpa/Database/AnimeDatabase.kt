package com.example.mfpa.Database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [AnimeEntity::class, AnimeQuoteEntity::class], version = 1)
abstract class AnimeDatabase : RoomDatabase() {

 abstract val animeDao: AnimeDao
 abstract val animeQuotesDao: AnimeQuotesDao

companion object{


 private var animeInst : AnimeDatabase? = null

 fun animeData (context: android.content.Context): AnimeDatabase? {

  if (animeInst == null){

   synchronized(AnimeDatabase::class.java){
    if (animeInst == null){
     animeInst = Room.databaseBuilder<AnimeDatabase>(context.applicationContext,
      AnimeDatabase::class.java, "Anime_Database").
     allowMainThreadQueries().build()
    }
   }
  }

  return animeInst
 }
}
}