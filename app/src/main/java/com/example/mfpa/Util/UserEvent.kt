package com.example.mfpa.Util

sealed class UserEvent{

    object PopBackStack: UserEvent()
    data class Navigate(val route:String) :UserEvent()
    data class ShowToastMessage(
        val message: String,
        val action: String? = null
        ):UserEvent()
}
