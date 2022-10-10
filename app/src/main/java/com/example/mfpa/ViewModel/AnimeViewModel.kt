package com.example.mfpa.ViewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.os.AsyncTask
import androidx.lifecycle.ViewModel
import com.example.mfpa.Database.AnimeDao
import com.example.mfpa.Database.AnimeDatabase
import com.example.mfpa.Database.AnimeEntity
import com.example.mfpa.Database.AnimeQuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val repository: AnimeQuoteRepository
) : ViewModel() {

init {

}



}