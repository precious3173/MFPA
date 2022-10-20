package com.example.mfpa.ViewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mfpa.Database.AnimeQuoteEntity
import com.example.mfpa.Database.AnimeQuotesDao
import com.example.mfpa.Database.Repository.AnimeQuoteRepository
import com.example.mfpa.Database.Repository.AnimeQuoteRepositoryList
import com.example.mfpa.Util.AddUpdateEvent
import com.example.mfpa.Util.UserEvent
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddQuoteViewModel @Inject
constructor(
    private val animeQuoteRepositoryList: AnimeQuoteRepository,
  //  private val state: SavedStateHandle
) : ViewModel() {

    private val _AddUpdateEvent = Channel<AddUpdateEvent> ()

    val AddUpdateEvents = _AddUpdateEvent.receiveAsFlow()

//    val animeQuoteEntity = state.get<AnimeQuoteEntity>("anime")

  /**  var animeCharacter = state.get<String>("character") ?: animeQuoteEntity?.character ?: ""
       set(value)  {
           field = value
           state.set("character", value)
       } **/


//    var animeQuote = state.get<String>("quote") ?: animeQuoteEntity?.quote ?: ""
//        set(value)  {
//            field = value
//            state.set("quote", value)
//        }

    fun onSave(){

//        if (animeCharacter.isBlank() && animeQuote.isBlank()){
//           emptyInput ("Character and Quote is empty")
//        }
//
//        if (animeQuoteEntity != null){
//          val update = animeQuoteEntity.copy(character = animeCharacter, quote = animeQuote)
//            updateQuote(update)
//        }
//        else{
//            val  addNew = AnimeQuoteEntity(character = animeCharacter, quote = animeQuote)
//
//            addNewQuote(addNew)
//        }
//        val delete = AnimeQuoteEntity(animeCharacter, animeQuote)
//        deleteQuote(delete)
    }


    private fun emptyInput(s: String) = viewModelScope.launch {

        _AddUpdateEvent.send(AddUpdateEvent.InvalidInput(s))
    }

    fun addNewQuote(animeQuoteEntity: AnimeQuoteEntity) = viewModelScope.launch {
         animeQuoteRepositoryList.insertQuote(animeQuoteEntity)
    }

    private fun updateQuote(animeQuoteEntity: AnimeQuoteEntity) = viewModelScope.launch {
        animeQuoteRepositoryList.updateQuote(animeQuoteEntity)
    }

    private fun deleteQuote(delete: AnimeQuoteEntity) = viewModelScope.launch {
        animeQuoteRepositoryList.deleteQuote(delete)

    }

    fun getQuotes(): Flow<List<AnimeQuoteEntity>> = animeQuoteRepositoryList.getQuotes()
}