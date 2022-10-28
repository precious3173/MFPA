package com.example.mfpa.Database.Repository

import android.app.Application
import com.example.mfpa.Database.AnimeDatabase
import com.example.mfpa.Database.AnimeQuoteEntity
import com.example.mfpa.Database.AnimeQuotesDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AnimeQuoteRepositoryList @Inject constructor (private val animeDatabase: AnimeDatabase): AnimeQuoteRepository {
    override suspend fun insertQuote(animeQuoteEntity: AnimeQuoteEntity) {
        animeDatabase.animeQuotesDao().insertQuote(animeQuoteEntity)
    }

    override suspend fun deleteQuote(animeQuoteEntity: AnimeQuoteEntity) {
        animeDatabase.animeQuotesDao().deleteQuote(animeQuoteEntity)
    }

    override suspend fun updateQuote(animeQuoteEntity: AnimeQuoteEntity) {
        animeDatabase.animeQuotesDao().updateQuote(animeQuoteEntity)
    }

    override fun getQuotes(): Flow<List<AnimeQuoteEntity>> {
       return animeDatabase.animeQuotesDao().getQuotes()
    }
}