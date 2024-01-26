package com.example.login.data

sealed class UIEvent {
    data class FirstNameChanged(val firstName:String) : UIEvent()
    data class LastNameChanged(val lastName:String) : UIEvent()
    data class EmailChanged(val email:String): UIEvent()
    data class PasswordChanged(val passowrd:String): UIEvent()

    object Registrationclicked : UIEvent()
}