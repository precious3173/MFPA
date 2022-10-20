package com.example.mfpa.ViewModel

import android.app.Application
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.mfpa.Database.AnimeQuoteEntity
import com.example.mfpa.Database.AnimeQuotesDao
import com.example.mfpa.Database.Repository.AnimeQuoteRepository
import com.example.mfpa.Util.AnimeListEvent
import com.example.mfpa.Util.UserEvent
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AnimeViewModel
 @Inject constructor(
   // private val animeQuotesDao: AnimeQuotesDao,
    //private val stateHandle: SavedStateHandle
) : ViewModel() {


   /**  val animeQuoteEntity = animeQuotesDao.getQuotes().asLiveData()


    val animeQuote = repository.getQuotes()


  private val _userEvent = Channel<UserEvent> ()
    
      val userEvent = _userEvent.receiveAsFlow()

    private var deletedAnime: AnimeQuoteEntity? = null
       fun onEvent (event: AnimeListEvent){

     when(event){

            is AnimeListEvent.onAnimeClick -> {
                sendUiEvent(UserEvent.Navigate(Routes.ADD_EDIT + "?animeId=${
               event.animeEntity.id}"))
            }
          is AnimeListEvent.onAddAnimeClick ->{
              sendUiEvent(UserEvent.Navigate(Routes.ADD_EDIT))
          }
          is AnimeListEvent.onUndoDeleteClick ->{
             deletedAnime?.let {
                 animeQuoteEntity ->
                 viewModelScope.launch {
                     repository.insertQuote(animeQuoteEntity)
                 }
             }
          }
           is AnimeListEvent.DeleteAnime -> {
             viewModelScope.launch {
                 deletedAnime = event.animeEntity
                 repository.deleteQuote(
                     event.animeEntity)
                 sendUiEvent(UserEvent.ShowToastMessage(
                     message = "Quote deleted",
                     action = "Undo"
                 ))
             }
           }


        }
    }

    private fun sendUiEvent(event: UserEvent){
        viewModelScope.launch{
            _userEvent.send(event)
        }
    }**/
}