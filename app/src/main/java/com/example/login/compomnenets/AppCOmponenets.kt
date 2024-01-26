@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.login.compomnenets

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.layout.RowScope

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.R
import com.example.login.ui.theme.BgColor
import com.example.login.ui.theme.GrayColor
import com.example.login.ui.theme.Primary
import com.example.login.ui.theme.Secondary
import com.example.login.ui.theme.TextColor
import androidx.compose.material3.Text as T

@Composable
fun NormalText(value:String)
{
    T(text = value, modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )

}

@Composable
fun HeadingText(value:String)
{
    T(text = value, modifier = Modifier
        .fillMaxWidth()
        .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(label: String, painterResource : Painter, onTextSelected: (String)-> Unit,errorStatus:Boolean) {
    val text = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()

            .background(BgColor),
        label = { Text(text = label) },
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = Primary,
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,


        ),

        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next) ,
        singleLine = true,
        maxLines = 1,

                value = text.value,
        onValueChange = {
            text.value = it
            onTextSelected(it)
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = null, Modifier.size(32.dp) ) }
         ,
        isError = !errorStatus
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyPasswordField(label: String, painterResource : Painter,onTextSelected: (String)-> Unit,errorStatus:Boolean) {
    val password = remember {
        mutableStateOf("")
    }

    val passwordvisible  = remember{ mutableStateOf(false) }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()

            .background(BgColor),
        label = { Text(text = label) },
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = Primary,
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,


            ),

        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done) ,
        singleLine = true,
        maxLines = 1,

        value = password.value,
        onValueChange = {
            password.value = it
            onTextSelected(it)
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = null, Modifier.size(32.dp) ) },
        trailingIcon = {
           val Iconimage = if(passwordvisible.value)
           {
               //Icon(painter = painterResource(id = R.drawable.img_4), contentDescription = null, Modifier.size(32.dp) )
               Icons.Filled.Visibility
           }
            else{
               //Icon(painter = painterResource(id = R.drawable.img_5), contentDescription = null, Modifier.size(32.dp) )
               Icons.Filled.VisibilityOff
           }

            val description= if(passwordvisible.value)
            {
                "Hide Password"
            }
            else{
                "SHow Password"
            }
            IconButton(onClick = { passwordvisible.value = !passwordvisible.value  }) {
                Icon(imageVector = Iconimage, contentDescription = description)
            }
        },
        visualTransformation = if(passwordvisible.value)
        {
            VisualTransformation.None
        }
        else{
            PasswordVisualTransformation()
        },
        isError = !errorStatus

    )
}


@Composable
fun checkbox()
{
    Row(modifier = Modifier
        .fillMaxWidth()
        .heightIn(45.dp)
        ,
        verticalAlignment = Alignment.CenterVertically)
        
    {
        val checked = remember{ mutableStateOf(false) }
    Checkbox(checked = checked.value, onCheckedChange ={checked.value = !checked.value} )

        val ini = "By continuing you accept our "
        val next = " Privacy Policy "
        val ne = " and "
        val end = "Terms of Use"

          ClickableText(text =
          buildAnnotatedString {
              append(ini)
              withStyle(style = SpanStyle(color = Primary))
              {
                  pushStringAnnotation(tag = next, annotation = next)
                  append(next)
              }
              append(ne)
              withStyle(style = SpanStyle(color = Primary))
              {
                  pushStringAnnotation(tag = end, annotation = end)
                  append(end)
              }
          }, onClick = {} )


        
        
    }
}





@Composable
fun Divider()
{
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically) {
        androidx.compose.material3.Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color = GrayColor,
            thickness = 1.dp,

            )

        Text("or",
            modifier = Modifier.padding(8.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = TextColor)

        androidx.compose.material3.Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color = GrayColor,
            thickness = 1.dp)

    }
}

@Composable
fun ButtonRegister(isEnabled:Boolean = false, onClicked:()->Unit) {
    Button(
        modifier = Modifier
        .fillMaxWidth()
        .height(45.dp),
        onClick = {onClicked.invoke()},
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent),

    )
    {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
            .background(
                brush = Brush.horizontalGradient(listOf(Color.Blue,Color.Magenta)),
                shape = RoundedCornerShape(50.dp)
            ),
            contentAlignment = Alignment.Center)
        {
            Text(text = "Register",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp)
        }
    }
}

@Composable
fun ButtonLogin() {
    Button(onClick = {},modifier = Modifier
        .fillMaxWidth()
        .height(45.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    )
    {

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
            .background(
                brush = Brush.horizontalGradient(listOf(Color.Red, Color.Blue)),
                shape = RoundedCornerShape(50.dp)
            ),
            contentAlignment = Alignment.Center)
        {
            Text(text = "Login",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp)
        }
    }
}

@Composable
fun undertext()
{
    val inni = "Forgot Your Password?"
    Row(modifier = Modifier.fillMaxWidth()) {
        ClickableText(modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center,
                color = GrayColor,
                textDecoration = TextDecoration.Underline
            ), text =buildAnnotatedString {
                append(inni)

                }

            ,
            onClick = {})
    }
}
