package com.example.login.data

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.login.data.rules.validator
import com.google.firebase.auth.FirebaseAuth

class RgesitrationViewModel : ViewModel() {

    private val TAG = RgesitrationViewModel::class.simpleName

    var registrationUIState = mutableStateOf(RegistrationUIState())

    var allvalidationspasses = mutableStateOf(false)

    var Indicator = mutableStateOf(false)
    var nav = mutableStateOf(false)
    fun onEVent(event : RegistrationUIEvent)
    {
        validatewithrules()
        when(event){
            is RegistrationUIEvent.FirstNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    firstName = event.firstName)
            }

            is RegistrationUIEvent.LastNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    lastName = event.lastName
                )

            }

            is RegistrationUIEvent.EmailChanged ->{
                registrationUIState.value = registrationUIState.value.copy(
                    email = event.email
                )
            }

            is RegistrationUIEvent.PasswordChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    password = event.passowrd
                )
            }

            is RegistrationUIEvent.Registrationclicked ->
            {
                createuserInFirebase(
                    email = registrationUIState.value.email,
                    password = registrationUIState.value.password
                )
            }
          else ->
          {}
            //is RegistrationUIEvent.PrivacycheckboxChanged ->{
             //   registrationUIState.value = registrationUIState.value.copy(
                       // privacyPolicyAccepted = event.status
              //  )
            //}
        }
    }

    private fun validatewithrules() {
            val fnameresult = validator.validateFirst(fname = registrationUIState.value.firstName)

        val lnameresult = validator.validateLast(lname =registrationUIState.value.lastName)

        val emailresult = validator.validateEmail(emaIl = registrationUIState.value.email)

        val passresult = validator.validatePassword(pass = registrationUIState.value.password)

       // val privacypolicyresult = validator.validatePrivacyPolicyAcceptance(statusValue = registrationUIState.value.privacyPolicyAccepted)
        registrationUIState.value = registrationUIState.value.copy(
            errorfirstName = fnameresult.status,
                    errorlastName = lnameresult.status,
                    erroremail =emailresult.status,
                    errorpassowrd = passresult.status,
           // privacyPolicyError = privacypolicyresult.status

        )


        allvalidationspasses.value = fnameresult.status && lnameresult.status && emailresult.status && passresult.status //&& privacypolicyresult.status
    }



private fun createuserInFirebase(email:String, password:String)
{
    Indicator.value = true
  FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password).
          addOnCompleteListener {
          Log.d(TAG,"isSuccessful = ${it.isSuccessful}")


            Indicator.value = false
              nav.value = true

          }
              .
          addOnFailureListener {
              Log.d(TAG,"isSuccessful = ${it.message}")
          }
}




}