package cat.itb.m78.exercices.Examen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.calculadora
import org.jetbrains.compose.resources.painterResource


@Composable
fun Menu(navController: NavController) {
    var result by remember { mutableStateOf(0.0) }
    var input by remember { mutableStateOf(TextFieldValue("")) }
    var operation by remember { mutableStateOf<(Double, Double) -> Double>({ a, _ -> a }) }
    Column(
        modifier = Modifier.fillMaxSize().background(Color.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Color.Gray)
                .padding(16.dp)
        ) {
            Text(text = result.toString(), fontSize = 50.sp)

            Row {
                listOf("+", "-", "*", "/").forEach { symbol ->
                    Button(onClick = {
                        operation = when (symbol) {
                            "+" -> { a, b -> a + b }
                            "-" -> { a, b -> a - b }
                            "*" -> { a, b -> a * b }
                            "/" -> { a, b -> if (b != 0.0) a / b else a }
                            else -> { a, _ -> a }
                        }
                    }) {
                        Text(symbol)
                    }
                }
            }

            TextField(
                value = input,
                onValueChange = { input = it },
                modifier = Modifier.padding(8.dp)
            )

            Row {
                Button(onClick = { navController.navigate("Resultado/${result}") }) {
                    Text("End")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = {
                    val num = input.text.toDoubleOrNull() ?: 0.0
                    result = operation(result, num)
                    input = TextFieldValue("")
                }) {
                    Text("Calculate")
                }
            }
        }
    }
}

@Composable
fun Resultat() {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "The final result is $//result", fontSize = 24.sp)
        Image(
            painter = painterResource(Res.drawable.calculadora),
            modifier = Modifier.size(210.dp),
            contentDescription = null
        )
    }
}


/*object CalculadoraExamen {

    @Serializable
    data object Menu

    @Serializable
    data object Resultat
}

@Composable
fun Calculadora() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = CalculadoraExamen.Menu) {

        composable<CalculadoraExamen.Menu> {
            Menu(
                navigateToResultat = { navController.navigate(CalculadoraExamen.Resultat) },
            )
        }
    }
}*/