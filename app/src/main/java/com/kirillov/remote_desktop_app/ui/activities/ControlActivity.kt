package com.kirillov.remote_desktop_app.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kirillov.remote_desktop_app.ui.components.CloseTabButton
import com.kirillov.remote_desktop_app.ui.components.FullscreenButton
import com.kirillov.remote_desktop_app.ui.components.PauseButton
import com.kirillov.remote_desktop_app.ui.components.ReopenTabButton

class ControlActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val serverAddress = intent.getStringExtra("SERVER_ADDRESS") ?: ""
        println(serverAddress)
        setContent {
            Header(serverAddress)
            Grid()
        }
    }
}

@Composable
fun Header(serverAddress: String) {
    Column(
        modifier = Modifier.padding(25.dp).fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Connected to: $serverAddress", style = typography.h6)
    }
}

@Composable
fun Grid() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(Modifier.padding(5.dp)) {
            PauseButton()
            FullscreenButton()
        }
        Row(Modifier.padding(5.dp)) {
            CloseTabButton()
            ReopenTabButton()
        }
    }
}