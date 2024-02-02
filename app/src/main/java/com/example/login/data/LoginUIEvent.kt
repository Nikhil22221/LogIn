package com.example.login.data

sealed class LoginUIEvent {

    data class LoginEmailChanged(val lemail:String): LoginUIEvent()
    data class LoginPasswordChanged(val lpassowrd:String): LoginUIEvent()

    object Loginclicked : LoginUIEvent()
}