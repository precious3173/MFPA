package com.example.mfpa.Database

import androidx.lifecycle.MutableLiveData

class AnimeDataStore {

    private val animeEntity = mutableListOf<AnimeEntity>()
    private val animes = MutableLiveData<List<AnimeEntity>>()

    init {
        animes.value = animeEntity
    }


}