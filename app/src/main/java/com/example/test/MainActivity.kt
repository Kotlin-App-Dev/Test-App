package com.example.test

import android.R
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.saveable.Saver
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

var uname = ""
var pass = ""
class MainActivity : ComponentActivity() {
    @SuppressLint("ComposableDestinationInComposeScope")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val page_jump = rememberNavController()
            NavHost(navController = page_jump, startDestination = "login"){
                composable("login") {
                    Login(page_jump)
                }
                composable("main-app"){
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun make_space(){
    Spacer(modifier = Modifier.height(35.dp))
}

@Composable
fun Login(navController: NavController) {
    var username by remember{ mutableStateOf("") }
    var password by remember{ mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth().background(Color.Black).padding(20.dp)
            ) {
            Text("Welcome to login page", modifier = Modifier.padding(horizontal = 60.dp), fontSize = 20.sp, color = Color.Green)
        }
        Column(modifier = Modifier.background(Color.Gray).fillMaxSize().padding(vertical = 250.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = username,
                onValueChange = { username = it },
                placeholder = { Text("Whats your name") }
            )
            make_space()
            TextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text("Whats your password") }
            )
            make_space()
            Button(onClick = {
                uname = username
                pass = password
                navController.navigate("main-app")
            }) { Text("Login") }
        }
    }
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF002B5B))
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome Back!", fontSize = 28.sp, color = Color.White, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1A75FF)),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text("Username: $uname", fontSize = 20.sp, color = Color.White)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Password: $pass", fontSize = 20.sp, color = Color.White)
            }
        }
    }
}