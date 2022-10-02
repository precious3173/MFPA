package com.example.mfpa.Database

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.os.AsyncTask
import com.example.mfpa.Database.AnimeDao
import com.example.mfpa.Database.AnimeDatabase
import com.example.mfpa.Database.AnimeEntity

class AnimeViewModel (application: Application) : AndroidViewModel(application) {

    private val animeDao: AnimeDao

    init {
        val  animeDatabase = AnimeDatabase.animeData(application)
        animeDao = animeDatabase!!.animeDao()
    }

    fun insert (animeEntity: AnimeEntity){
        InsertAsyn(animeDao).execute(animeEntity)

    }

    private inner class InsertAsyn(private val animeDao: AnimeDao) : AsyncTask<AnimeEntity, Void, Void>
}