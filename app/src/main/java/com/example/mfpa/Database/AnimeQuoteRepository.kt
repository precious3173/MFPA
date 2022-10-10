package com.example.mfpa.Database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

interface AnimeQuoteRepository {

    suspend fun insertQuote(animeQuoteEntity: AnimeQuoteEntity)


    suspend fun deleteQuote(animeQuoteEntity: AnimeQuoteEntity)

    suspend fun updateQuote(animeQuoteEntity: AnimeQuoteEntity)


    suspend fun getQuoteId(id: Int):AnimeQuoteEntity?


    fun getQuotes() : Flow<List<AnimeQuoteEntity>>
}