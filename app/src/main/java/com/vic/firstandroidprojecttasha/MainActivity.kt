package com.vic.firstandroidprojecttasha

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vic.firstandroidprojecttasha.ui.theme.FirstAndroidProjectTashaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstAndroidProjectTashaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(5.dp),
                    color = MaterialTheme.colorScheme.background
                ){
                Column {
                    HelloWorld("Mobstarrs")
                    Button(onClick = {
                        val intent = Intent(this@MainActivity,LoginActivity::class.java)
                        startActivity(intent)
                    },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        colors = ButtonDefaults.buttonColors(Color.DarkGray))
                    {
                        Text(text = "Login here")
                    }
                    Button(onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        colors = ButtonDefaults.buttonColors(Color.Black))
                    {
                        Text(text = "Register here")
                    }
                }
            }

            }
        }
    }
}
@Composable
fun HelloWorld(name:String){
    Column (
        modifier = Modifier
                 .clip(shape = RoundedCornerShape(20.dp)),

    )
    {
        Text(text = "Hey $name!Welcome back",
            fontSize = 15
                .sp,
            color = Color.Black,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.White)
                .padding(20.dp)
                .wrapContentHeight(align = Alignment.CenterVertically)
        )
        Spacer(modifier = Modifier.height(20.dp))
        ImageComponent()
        Spacer(modifier = Modifier.height(20.dp))
        TextFieldComponent()
        Spacer(modifier = Modifier.height(20.dp))
        TextFielEmaildComponent()
        Spacer(modifier = Modifier.height(20.dp))
        TextFieldLocationComponent()
        Spacer(modifier = Modifier.height(20.dp))
        PasswordTextField()
        Spacer(modifier = Modifier.height(20.dp))



//        Text(text = "I am a software developer/Android developer",
//            fontSize = 23.sp,
//            color = Color.Red,
//            fontFamily = FontFamily.SansSerif,
//            fontStyle = FontStyle.Italic,
//            textAlign = TextAlign.Center,
//            modifier = Modifier.background(Color.Blue)
//                .padding(20.dp)
//                .wrapContentHeight(align = Alignment.CenterVertically)
//        )
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HelloWorldPreview(){
    HelloWorld("Mobstarrs")
}
@Composable
fun TextFieldComponent(){
    var text by remember {
        mutableStateOf(value = "")
    }
    TextField(modifier = Modifier.fillMaxWidth(),
              
        value = text, onValueChange = {
        newText -> text = newText
    },
        label = { Text(text = "Enter your name")},
        placeholder = {
            Text(text = "Please enter your name")
        })


}

@Composable
fun TextFielEmaildComponent(){
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
fun TextFieldLocationComponent(){
    var text by remember {
        mutableStateOf(value = "")
    }
    TextField(modifier = Modifier.fillMaxWidth(),

        value = text, onValueChange = {
                newText -> text = newText
        },
        label = { Text(text = "Enter your location")},
        placeholder = {
            Text(text = "Please enter your location")
        })


}
@Composable
fun PasswordTextField() {
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    val icon = if (passwordVisibility)
        painterResource(id = R.drawable.design_ic_visibility)
    else
        painterResource(id = R.drawable.design_ic_visibility_off)

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = password,
        onValueChange = {
            password = it
        },
        placeholder = { Text(text = "Password") },
        label = { Text(text = "Password") },
        trailingIcon = {
            IconButton(onClick = { passwordVisibility = !passwordVisibility })
            {
                Icon(painter = icon, contentDescription = "Visibility Icon")
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = if (passwordVisibility) VisualTransformation.None
        else PasswordVisualTransformation()

    )
}

