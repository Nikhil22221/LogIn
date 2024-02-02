package com.example.login.data

sealed class RegistrationUIEvent {
    data class FirstNameChanged(val firstName:String) : RegistrationUIEvent()
    data class LastNameChanged(val lastName:String) : RegistrationUIEvent()
    data class EmailChanged(val email:String): RegistrationUIEvent()
    data class PasswordChanged(val passowrd:String): RegistrationUIEvent()
     data class PrivacycheckboxChanged(val status:Boolean): RegistrationUIEvent()
    object Registrationclicked : RegistrationUIEvent()
}