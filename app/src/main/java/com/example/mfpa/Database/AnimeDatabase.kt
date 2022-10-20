package com.example.mfpa.Database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [AnimeQuoteEntity::class], version = 1)
abstract class AnimeDatabase : RoomDatabase() {

 abstract fun animeQuotesDao(): AnimeQuotesDao

 /**class AnimeCallback @Inject constructor(
     private val database: Provider <AnimeDatabase>,
     @AppModule.CoroutineSco private val animeCoroutine: CoroutineScope

     ): RoomDatabase.Callback(){

     override fun onCreate(db: SupportSQLiteDatabase) {
         super.onCreate(db)

        val animeQuotesDao = database.get().animeQuotesDao()

     }
 } **/


}