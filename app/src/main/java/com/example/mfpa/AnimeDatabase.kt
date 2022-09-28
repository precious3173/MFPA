package com.example.mfpa

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.processor.Context


@Database(entities = [AnimeEntity::class], version = 1)
abstract class AnimeDatabase : RoomDatabase() {

 abstract fun animeDao(): AnimeDao

companion object{


 private var animeInst : AnimeDatabase? = null

 fun database (context: android.content.Context): AnimeDatabase? {

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