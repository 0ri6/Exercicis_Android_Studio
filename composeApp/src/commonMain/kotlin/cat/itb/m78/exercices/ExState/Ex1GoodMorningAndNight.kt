package cat.itb.m78.exercices.ExState

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun GoodMaN (){
    var message by remember { mutableStateOf("Good ?!")}

    Column (modifier = Modifier.fillMaxSize().background(Color.Black)) {
        Text(color = Color.White, text = message)
        Button(onClick = {
            message = "Good Morning!"
            }) {
            Text("Morning")
        }
        Button(onClick = {
            message = "Good Night!"
        }) {
            Text("Night")
        }
    }
}
