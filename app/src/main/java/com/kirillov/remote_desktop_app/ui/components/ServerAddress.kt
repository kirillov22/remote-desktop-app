package com.kirillov.remote_desktop_app.ui.components

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.kirillov.remote_desktop_app.ui.activities.ControlActivity

@Composable
fun ServerAddress() {
    val context = LocalContext.current
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val textState = remember { mutableStateOf(TextFieldValue()) }
            OutlinedTextField(
                value = textState.value,
                onValueChange = { textState.value = it },
                label = { Text("Enter server ip address and port") },
                modifier = Modifier.padding(16.dp)
            )
            Button(onClick = {
                val intent = Intent(context, ControlActivity::class.java).apply {
                    putExtra("SERVER_ADDRESS", textState.value.text)
                }
                startActivity(context, intent, null)

            }) {
                Text("Connect")
            }
        }
    }
}
