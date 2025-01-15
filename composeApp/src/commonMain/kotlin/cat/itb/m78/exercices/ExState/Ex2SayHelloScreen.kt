package cat.itb.m78.exercices.ExState

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
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
import io.ktor.websocket.Frame

@Composable
fun HelloScreen() {
    Column (modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
        var text by remember { mutableStateOf("") }
        OutlinedTextField(text,
            label = { Text("Name") },
            onValueChange = {
                text = it
            })

        var showDialog by remember { mutableStateOf(false) }
        if (showDialog)
            AlertDialog(
                onDismissRequest = { showDialog = false },
                confirmButton = {},
                text = { Text("HELLO!! " + text) }
            )
        Button(onClick = { showDialog = true }) {
            Text(text = "Say Hello")
        }
    }
}