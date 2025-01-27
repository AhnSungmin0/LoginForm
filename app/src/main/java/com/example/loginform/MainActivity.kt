package com.example.loginform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginform.ui.theme.LoginFormTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginFormTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var username: String by remember { mutableStateOf("")}
    var password: String by remember { mutableStateOf("")}
    Column {
        Text(
            text = "Login",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.primary,
            modifier = modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        OutlinedTextField(
            modifier=Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp),
            value=username,
            onValueChange = {username=it.replace(',','.')},
            label= {Text("Username")},
            placeholder = {Text("Username")},
            trailingIcon = {val image=Icons.Default.Email
                Icon(imageVector = image,"")
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        OutlinedTextField(
            modifier=Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp),
            value=password,
            onValueChange = {password=it.replace(',','.')},
            label= {Text("Password")},
            placeholder = {Text("Password")},
            visualTransformation=PasswordVisualTransformation(),
            trailingIcon = {val image=Icons.Default.Lock
                Icon(imageVector = image,"")
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        Button(onClick = {/*Not actual login function*/},
            modifier=Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp)
        ) {Text("Submit") }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginFormTheme {
        Greeting("Android")
    }
}