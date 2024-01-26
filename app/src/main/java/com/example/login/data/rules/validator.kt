package com.example.login.data.rules

object validator {
    fun validateFirst(fname:String) : validateresult
    {
            return validateresult(
                (!fname.isNullOrEmpty() && fname.length>=3)
            )
    }

    fun validateLast(lname:String) : validateresult
    {
        return validateresult(
            (!lname.isNullOrEmpty() && lname.length>=3)
        )
    }

    fun validateEmail(emaIl:String) : validateresult
    {
        return validateresult(
            (!emaIl.isNullOrEmpty() )
        )
    }

    fun validatePassword(pass:String) : validateresult
    {
        return validateresult(
            (!pass.isNullOrEmpty() && pass.length>=4)
        )
    }

    data class validateresult(
        val status:Boolean = false
    )
}