package com.example.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login.app.PostOfficeApp
import com.example.login.screen.LoginScreen
import com.example.login.screen.SignUpScreen
import com.example.login.ui.theme.LOGInTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login.screen.Home

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //LOGInTheme
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    navigate()
                }

        }
    }
}

@Composable
fun navigate()
{
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login")
    {
        composable("login")
        {
            LoginScreen(navController)
        }
        composable("signup")
        {
            SignUpScreen(navController)
        }
       composable("home"){
         Home(navController )
       }
    }
}



