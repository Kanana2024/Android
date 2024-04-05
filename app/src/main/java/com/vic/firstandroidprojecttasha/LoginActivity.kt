package com.vic.firstandroidprojecttasha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vic.firstandroidprojecttasha.ui.theme.FirstAndroidProjectTashaTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstAndroidProjectTashaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                LoginScreen("User")
                }
            }
        }
    }
}

@Composable
fun LoginScreen(name:String){
    Column (modifier = Modifier
        .clip(shape = RoundedCornerShape(10.dp))
    ){
        Text(text = "Hey $name!Please login here",
            fontSize = 15
                .sp,
            color = Color.Black,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.Blue)
                .padding(20.dp)
                .wrapContentHeight(align = Alignment.CenterVertically)
        )
        Spacer(modifier = Modifier.height(20.dp))
        ImageComponent()
        Spacer(modifier = Modifier.height(20.dp))
        TextFieldUsernameComponent()
        Spacer(modifier = Modifier.height(20.dp))
        TextFieldEmailComponent()
        Spacer(modifier = Modifier.height(20.dp))
        TextFieldPasswordComponent()
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp))
        {
            Text(text = "Login here")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp))
        {
            Text(text = "Register here")
        }
    }

}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview(){
    LoginScreen("User")
}
@Composable
fun TextFieldUsernameComponent(){
    var text by remember {
        mutableStateOf(value = "")
    }
    TextField(modifier = Modifier.fillMaxWidth(),

        value = text, onValueChange = {
                newText -> text = newText
        },
        label = { Text(text = "Enter your username")},
        placeholder = {
            Text(text = "Please enter your username")
        })


}
@Composable
fun TextFieldEmailComponent(){
    var text by remember {
        mutableStateOf(value = "")
    }
    TextField(modifier = Modifier.fillMaxWidth(),

        value = text, onValueChange = {
                newText -> text = newText
        },
        label = { Text(text = "Enter your email")},
        placeholder = {
            Text(text = "Please enter your email")
        })


}

@Composable
fun TextFieldPasswordComponent(){
    var text by remember {
        mutableStateOf(value = "")
    }
    TextField(modifier = Modifier.fillMaxWidth(),

        value = text, onValueChange = {
                newText -> text = newText
        },
        label = { Text(text = "Enter your password")},
        placeholder = {
            Text(text = "Please enter your password")
        })


}
@Composable
fun ImageComponent(){
  Image(modifier = Modifier
      .wrapContentHeight()
      .fillMaxWidth()
      .height(80.dp),
      painter = painterResource(id = R.drawable.images) , contentDescription ="mylogo" )
}