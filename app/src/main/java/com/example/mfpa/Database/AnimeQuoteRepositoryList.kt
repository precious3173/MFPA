package com.example.mfpa.Database

import kotlinx.coroutines.flow.Flow

class AnimeQuoteRepositoryList(private val animeQuoteDao : AnimeQuotesDao): AnimeQuoteRepository {
    override suspend fun insertQuote(animeQuoteEntity: AnimeQuoteEntity) {
        animeQuoteDao.insertQuote(animeQuoteEntity)
    }

    override suspend fun deleteQuote(animeQuoteEntity: AnimeQuoteEntity) {
        animeQuoteDao.deleteQuote(animeQuoteEntity)
    }

    override suspend fun updateQuote(animeQuoteEntity: AnimeQuoteEntity) {
        animeQuoteDao.updateQuote(animeQuoteEntity)
    }

    override suspend fun getQuoteId(id: Int): AnimeQuoteEntity? {
        return animeQuoteDao.getQuoteId(id)
    }

    override fun getQuotes(): Flow<List<AnimeQuoteEntity>> {
        animeQuoteDao.getQuotes()
    }
}