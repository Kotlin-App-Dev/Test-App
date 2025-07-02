package com.example.test

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.util.fastCbrt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Banner()
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Banner() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val is_Enable by derivedStateOf { username.isNotEmpty() && password.isNotEmpty() }
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black,
                    titleContentColor = Color.White
                ),
                title = { Text("Login app") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(Color.Gray)
                .padding(bottom = 100.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = username,
                onValueChange = { username = it.trim() },
                placeholder = { Text("Username") }
            )
            Spacer(modifier = Modifier.height(50.dp))
            TextField(
                value = password,
                visualTransformation = PasswordVisualTransformation(),
                onValueChange = { password = it.trim() },
                placeholder = { Text("Password") }
            )
            Spacer(modifier = Modifier.height(50.dp))
            val context = LocalContext.current
            Button(onClick = { if(is_Enable == true) { Toast.makeText(context,"Welcome $username, \n\'$password\' is your password so, don\'t forget it", Toast.LENGTH_LONG).show() } }, enabled = is_Enable) { Text("Submit") }
        }
    }

}
