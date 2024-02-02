package com.example.login.data

data class RegistrationUIState(
    var firstName: String="",
    var lastName: String="",
    var email: String="",
    var password: String="",
    var privacyPolicyAccepted:Boolean = false,

    var errorfirstName:Boolean = false,
    var errorlastName:Boolean = false,
    var erroremail:Boolean = false,
    var errorpassowrd:Boolean = false,

    var privacyPolicyError:Boolean = false
)