package com.example.mfpa.Util

sealed class AddUpdateEvent{
    data class InvalidInput(val invalidinput:String) :AddUpdateEvent()
    data class NavigateBack(val back: Int) : AddUpdateEvent()
}
