package com.example.login.ui.theme

import android.app.Application
import com.google.firebase.FirebaseApp

class LOGIn: Application() {

    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)
    }
}