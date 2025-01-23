package cat.itb.m78.exercices.ExViewModel

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.background_color
import org.jetbrains.compose.resources.painterResource

@Composable
fun CounterStrike() {
    Image(
        painter = painterResource(Res.drawable.background_color),
        modifier = Modifier.fillMaxSize(),
        contentDescription = null,
        contentScale = ContentScale.FillBounds
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val viewModel = viewModel { CSViewModel() }
        Row {
            Column {
                Text(viewModel.num1.value.toString())

                Button(onClick = { viewModel.increasenum1() }) {
                    Text("GOL Local")
                }
            }
            Column {
                Text(viewModel.num2.value.toString())
                Button(onClick = { viewModel.increasenum2() }) {
                    Text("GOL Visitant")
                }
            }
        }
    }
}

class CSViewModel : ViewModel() {
    val num1 = mutableStateOf(0)
    val num2 = mutableStateOf(0)

    fun increasenum1() {
        num1.value++
    }

    fun increasenum2() {
        num2.value++
    }
}