package com.example.mfpa.Util

import com.example.mfpa.Database.AnimeQuoteEntity

sealed class AnimeListEvent{

    data class DeleteAnime(val animeEntity: AnimeQuoteEntity) : AnimeListEvent()
    data class OnDoneChange(val animeEntity: AnimeQuoteEntity, val isDone: Boolean) : AnimeListEvent()
    object onUndoDeleteClick : AnimeListEvent()
    data class onAnimeClick(val animeEntity: AnimeQuoteEntity): AnimeListEvent()
    object onAddAnimeClick : AnimeListEvent()

}
