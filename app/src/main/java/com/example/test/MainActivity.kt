package com.example.test // Make sure this matches your project package

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.webkit.ConsoleMessage.MessageLevel.LOG
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                First()
            }
        }
    }
}

@Composable
fun Banner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .height(65.dp)
            .padding(20.dp)
    ) {
        Text("My APP", color = Color.White)
    }
}

@Composable
fun HelloWorldScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), // Optional padding
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "User information",
            color = Color.Magenta,
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(50.dp))
        var name by remember { mutableStateOf("") }
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Your name ?") }
        )
        Spacer(modifier = Modifier.height(50.dp))
        val context = LocalContext.current
        Button(onClick = {
            Toast.makeText(context,name, Toast.LENGTH_SHORT).show()
        }
        ) {
            Text("Click me ")
        }
    }
}

@Composable
fun First(){
    Column(
        modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxSize()
    ) {
        Banner()
        Spacer(modifier = Modifier.height(160.dp))
        HelloWorldScreen()
    }
}

