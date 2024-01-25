package com.example.login.app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.login.compomnenets.HeadingText
import com.example.login.compomnenets.NormalText

@Composable
fun PostOfficeApp()
{
    Surface(modifier = Modifier.fillMaxSize(),
        color = Color.White) {

    }
    Column (modifier = Modifier.fillMaxSize()){
        NormalText(value = "Hey There,")
        HeadingText(value = "Welcome Back")
    }
}


@Preview
@Composable
fun showPreviewPostOfficeApp()
{
    PostOfficeApp()
}