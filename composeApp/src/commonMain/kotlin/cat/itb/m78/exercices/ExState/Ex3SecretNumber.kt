package cat.itb.m78.exercices.ExState

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em

@Composable
fun SecretNumber()
{
    Column (horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()){
        Text("Endevina el número secret!!", fontWeight = FontWeight.Bold)
        var text by remember { mutableStateOf("") }
        OutlinedTextField(text,
            label = { Text("") },
            onValueChange = {
                text = it
            })
        if (text. == 50) {

        }
       var intents =
        Button(onClick = { intents = 1 }) {
            Text("Validar")
        }
        var textIntents by remember{ mutableStateOf("Intents: " ) }
        Text(text = textIntents)
    }
}