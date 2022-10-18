package com.example.mfpa.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface AnimeQuotesDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuote(animeQuoteEntity: AnimeQuoteEntity)

    @Delete
    suspend fun deleteQuote(animeQuoteEntity: AnimeQuoteEntity)

    @Update
    suspend fun updateQuote(animeQuoteEntity: AnimeQuoteEntity)

    //@Query ("Select *from animeQuote where id = :id")
    //suspend fun getQuoteId(id: Int):AnimeQuoteEntity?

    @Query ("SELECT *FROM animeQuote")
    fun getQuotes() : Flow<List<AnimeQuoteEntity>>

}