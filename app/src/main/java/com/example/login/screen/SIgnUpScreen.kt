package com.example.login.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDeepLink
import androidx.navigation.compose.rememberNavController
import com.example.login.R
import com.example.login.app.PostOfficeApp
//import com.example.login.compomnenets.ButtonComponent
//import com.example.login.compomnenets.ButtonComponent1
import com.example.login.compomnenets.Divider
import com.example.login.compomnenets.HeadingText
import com.example.login.compomnenets.MyPasswordField
import com.example.login.compomnenets.MyTextField
import com.example.login.compomnenets.NormalText
import com.example.login.compomnenets.checkbox
import com.example.login.compomnenets.endtext
import com.example.login.ui.theme.Primary
import com.example.login.ui.theme.Secondary

@Composable
fun SignUpScreen(navController: NavController)
{
    Surface(


        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)


    ) {
        Image(painter = painterResource(id = R.drawable.img_9),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxSize())
        Column(modifier = Modifier.fillMaxSize().padding(28.dp))
        {
            NormalText(value = "Hey There,")
            HeadingText(value = "Create An Account")
            Spacer(modifier = Modifier.height(20.dp))
            MyTextField(label = "First Name", painterResource(id = R.drawable.img_1))
            MyTextField(label = "Last Name", painterResource(id = R.drawable.img_1))
            MyTextField(label = "Email", painterResource(id = R.drawable.img_2))
           MyPasswordField(label = "Password", painterResource(id = R.drawable.img_3) )
            Spacer(modifier = Modifier.height(5.dp))
            checkbox()
            Spacer(modifier = Modifier.height(65.dp))

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
                            brush = Brush.horizontalGradient(listOf(Secondary, Primary)),
                            shape = RoundedCornerShape(50.dp)
                        ),
                        contentAlignment = Alignment.Center)
                    {
                        Text(text = "Register",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp)
                    }
                }

            Spacer(modifier = Modifier.height(15.dp))
            Divider()
            Spacer(modifier = Modifier.height(15.dp))
            val ini = "Already have an account? "
            val next = " Login "

            Row(modifier = Modifier
                .fillMaxWidth()
                .heightIn(45.dp)
                ,
                verticalAlignment = Alignment.CenterVertically)
            {
                ClickableText(modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal,
                        textAlign = TextAlign.Center
                    ), text =
                    buildAnnotatedString {
                        append(ini)
                        withStyle(style = SpanStyle(color = Primary))
                        {
                            pushStringAnnotation(tag = next, annotation = next)
                            append(next)
                        }

                    },
                    onClick = {navController.navigate("login")})
            }

        }

    }

        }





@Preview
@Composable
fun showPreviewSignUpScreen()
{
    SignUpScreen(navController = rememberNavController())
}
