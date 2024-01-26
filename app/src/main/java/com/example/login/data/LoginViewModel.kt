package com.example.login.data

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.login.data.rules.validator

class LoginViewModel : ViewModel() {
    var registrationUIState = mutableStateOf(RegistrationUIState())

    fun onEVent(event : UIEvent)
    {
        //validatewithrules()
        when(event){
            is UIEvent.FirstNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    firstName = event.firstName)
            }

            is UIEvent.LastNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    lastName = event.lastName
                )

            }

            is UIEvent.EmailChanged ->{
                registrationUIState.value = registrationUIState.value.copy(
                    email = event.email
                )
            }

            is UIEvent.PasswordChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    password = event.passowrd
                )
            }

            is UIEvent.Registrationclicked ->
            {
                validatewithrules()
            }
        }
    }

    private fun validatewithrules() {
            val fnameresult = validator.validateFirst(fname = registrationUIState.value.firstName)

        val lnameresult = validator.validateLast(lname =registrationUIState.value.lastName)

        val emailresult = validator.validateEmail(emaIl = registrationUIState.value.email)

        val passresult = validator.validatePassword(pass = registrationUIState.value.password)

        registrationUIState.value = registrationUIState.value.copy(
            errorfirstName = fnameresult.status,
                    errorlastName = lnameresult.status,
                    erroremail =emailresult.status,
                    errorpassowrd = passresult.status

        )
    }





}