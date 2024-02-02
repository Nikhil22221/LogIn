package com.example.login.data.rules

object validatorlogin {





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

        fun validatePrivacyPolicyAcceptancel(statusValue:Boolean): validateresult{
            return validateresult(
                statusValue
            )
        }

        data class validateresult(
            val status:Boolean = false
        )
    }
