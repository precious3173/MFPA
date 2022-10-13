package com.example.mfpa.Database.Repository

import com.example.mfpa.Database.AnimeQuoteEntity
import kotlinx.coroutines.flow.Flow

interface AnimeQuoteRepository {

    suspend fun insertQuote(animeQuoteEntity: AnimeQuoteEntity)

    suspend fun deleteQuote(animeQuoteEntity: AnimeQuoteEntity)

    suspend fun updateQuote(animeQuoteEntity: AnimeQuoteEntity)

    suspend fun getQuoteId(id: Int): AnimeQuoteEntity?

    fun getQuotes() : Flow<List<AnimeQuoteEntity>>
}