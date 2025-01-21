package cat.itb.m78.exercices.ExState

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
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
import cat.itb.m78.exercices.ExStateless.contact

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

        val randomnumber = 33

        val message = remember { mutableStateOf("") }


       val intents = remember { mutableStateOf(0) }
        Button(onClick = { intents.value ++
            if (text.toInt() == randomnumber){
                message.value = "Has encertat!!"
            }
            else {
                if (text.toInt() > randomnumber){
                    message.value = "El número que busques és més petit!!"
                }
                else
                message.value = "El número que busques és més gran!!"
            }
        }) {
            Text("Validar")
        }

        Text("Intents: " + intents.value)
        Text(message.value)

        Button(onClick = {intents.value = 0}) {
            Icon(Icons.Default.Refresh, "Refresh")
        }
    }


}