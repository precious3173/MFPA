package com.example.mfpa.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.mfpa.Module.AppModule
import kotlinx.coroutines.AbstractCoroutine
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider


@Database(entities = [AnimeQuoteEntity::class], version = 1)
abstract class AnimeDatabase : RoomDatabase() {

 abstract fun animeQuotesDao(): AnimeQuotesDao

 class AnimeCallback @Inject constructor(
     private val database: Provider <AnimeDatabase>,
     @AppModule.CoroutineSco private val animeCoroutine: CoroutineScope

     ): RoomDatabase.Callback(){

     override fun onCreate(db: SupportSQLiteDatabase) {
         super.onCreate(db)

        val animeQuotesDao = database.get().animeQuotesDao()

         //animeCoroutine.launch {
         //    animeQuotesDao.insertQuote(AnimeQuoteEntity())
         //}
     }
 }

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