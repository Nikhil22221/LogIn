package com.example.login.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Home(navController: NavController)
{
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        
        Surface(modifier = Modifier.fillMaxSize(),
            color = Color.White) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(28.dp)
                .clickable { navController.navigate("login") })

            {
                Text(text = "Hello")
                Text(text = "World")
            }
        }
        
    }
}

@Preview
@Composable
fun showPreviewHome()
{
    Home(navController = rememberNavController())
}