package com.example.login.data

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.login.data.rules.validator
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel : ViewModel() {
    var registrationUIState = mutableStateOf(RegistrationUIState())

    var allvalidationspasses = mutableStateOf(false)
    fun onEVent(event : UIEvent)
    {
        validatewithrules()
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
                createuserInFirebase(
                    email = registrationUIState.value.email,
                    password = registrationUIState.value.password
                )
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


        allvalidationspasses.value = fnameresult.status && lnameresult.status && emailresult.status && passresult.status
    }


private fun createuserInFirebase(email:String, password:String)
{
  FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password).
          addOnCompleteListener {
          Log.d(TAG,"isSuccessful = ${it.isSuccessful}")
          }.
          addOnFailureListener {
              Log.d(TAG,"isSuccessful = ${it.message}")
          }
}




}