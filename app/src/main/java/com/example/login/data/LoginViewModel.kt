package com.example.login.data

import android.content.ContentValues
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.login.data.rules.validator
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel : ViewModel() {
    private val TAG = LoginViewModel::class.simpleName

    var loginUIState = mutableStateOf(LoginUIState())

    var allvalidationspasseslogin = mutableStateOf(false)

    var Indicatorlog = mutableStateOf(false)

    var nav1 = mutableStateOf(false)

    var isSnackbarVisible = mutableStateOf(true)
    fun onEVent(event : LoginUIEvent)
    {
        validatewithruleslogin()
        when(event){


            is LoginUIEvent.LoginEmailChanged ->{
                loginUIState.value = loginUIState.value.copy(
                    email = event.lemail
                )
            }

            is LoginUIEvent.LoginPasswordChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    password = event.lpassowrd
                )
            }

            is LoginUIEvent.Loginclicked ->
            {
                signInFirebase(
                    email = loginUIState.value.email,
                    password = loginUIState.value.password
                )
            }


        }
    }

    private fun validatewithruleslogin() {


        val emailresult = validator.validateEmail(emaIl = loginUIState.value.email)

        val passresult = validator.validatePassword(pass = loginUIState.value.password)


        loginUIState.value = loginUIState.value.copy(

            erroremail =emailresult.status,
            errorpassowrd = passresult.status,


        )


        allvalidationspasseslogin.value =  emailresult.status && passresult.status
    }



    private fun signInFirebase(email:String, password:String)
    {

        Indicatorlog.value = true
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password).
        addOnCompleteListener {
            Log.d(TAG,"isSuccessful = ${it.isSuccessful}")

            if(it.isSuccessful) {
                Indicatorlog.value = false
                nav1.value = true
            }
            else
            {
                Indicatorlog.value = false

            }
        }
            .
            addOnFailureListener {
                Log.d(TAG,"isSuccessful = ${it.message}")
            }
    }

    @Composable
    fun snack()
    {
        val context = LocalContext.current
        Toast.makeText(context,"Please Enter The Correct Deatils",Toast.LENGTH_SHORT)
    }




}