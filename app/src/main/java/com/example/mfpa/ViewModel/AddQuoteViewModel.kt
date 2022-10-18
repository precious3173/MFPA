package com.example.mfpa.ViewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.mfpa.Database.AnimeQuoteEntity
import com.example.mfpa.Database.AnimeQuotesDao
import dagger.assisted.Assisted
import javax.inject.Inject

class AddQuoteViewModel @Inject constructor(
    private val animeQuotesDao: AnimeQuotesDao,
    @Assisted private val state: SavedStateHandle
) : ViewModel() {

    val animeQuoteEntity = state.get<AnimeQuoteEntity>("anime")

    var animeCharacter = state.get<String>("character") ?: animeQuoteEntity?.character ?: ""
       set(value)  {
           field = value
           state.set("character", value)
       }


    var animeQuote = state.get<String>("quote") ?: animeQuoteEntity?.quote ?: ""
        set(value)  {
            field = value
            state.set("quote", value)
        }
}