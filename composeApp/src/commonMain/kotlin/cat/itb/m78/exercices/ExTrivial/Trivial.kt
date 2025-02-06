package cat.itb.m78.exercices.ExTrivial

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.trivial
import org.jetbrains.compose.resources.painterResource

@Composable
fun Trivial(navigateToSettings: () -> Unit, navigateToGame: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.Cyan),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(Res.drawable.trivial),
            modifier = Modifier.size(210.dp),
            contentDescription = null
        )
        Spacer(Modifier.height(20.dp))
        Button(onClick = { navigateToGame() }) {
            Text("New Game")
        }
        Spacer(Modifier.height(20.dp))
        Button(onClick = { navigateToSettings() }) {
            Text("Settings")
        }
    }
}

@Composable
fun Settings(navigateToMenu: () -> Unit) {
    Column {
        Row {
            Text("Difficulty")
        }

    }
}

@Composable
fun Answer(navigateToMenu: () -> Unit) {
    Column {
        Row {
            Text("Has acertat 0/0")
        }

    }
}

@Composable
fun Quiz(navigateToAnswer: () -> Unit) {
//    var error1 by remember { mutableStateOf(Color.Gray) }
//    var error2 by remember { mutableStateOf(Color.Gray) }
//    var error3 by remember { mutableStateOf(Color.Gray) }
//    var correcte by remember { mutableStateOf(Color.Gray) }

    val preguntes = listOf(
        Pregunta("",listOf(""),1),
        Pregunta("Como es diu el professor de llenguatge de marques?",listOf("Marc", "Juan", "Mateu", "Pere"),3),
        Pregunta("Quina és la nota mitja de programació?", listOf("1", "3", "5", "6"), 1),
        Pregunta("Qui és el delegat?", listOf("Yeray", "Eudald", "Laia", "Alvaro"), 1),
        Pregunta("", listOf("0", "0", "0"), 1),
        Pregunta("", listOf("0", "0"), 1),
        Pregunta("", listOf("0", "0", "0", "0","0"), 1),
        Pregunta("", listOf("0", "0", "0", "0"), 1),
        Pregunta("", listOf("0", "0", "0", "0"), 1),
        Pregunta("", listOf("0", "0", "0", "0"), 1),
        Pregunta("", listOf("0", "0", "0", "0"), 1),
        Pregunta("", listOf("0", "0", "0", "0"), 1),
        Pregunta("", listOf("0", "0", "0", "0"), 1),
        )
    var preguntareferentactual by remember { mutableStateOf(0) }
    val preguntaactual = preguntes[preguntareferentactual]


    Column(
        modifier = Modifier.fillMaxSize().background(Color.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(20.dp))
        Text("Ronda actual: $preguntareferentactual/15")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            preguntaactual.text,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(50.dp))

        preguntaactual.respostes.forEachIndexed { index, respostes ->
            Button(onClick = {if (preguntareferentactual < preguntes.size - 1){preguntareferentactual++} else {preguntareferentactual = 1} },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    ){ Text(text = respostes)}
        }

/*        Row {
//            Button(
//                onClick = { error1 = Color.Red },
//                colors = ButtonDefaults.buttonColors(containerColor = error1)
//            ) {
//                Text("1789")
//            }
//            Spacer(Modifier.width(10.dp))
//            Button(
//                onClick = { error2 = Color.Red },
//                colors = ButtonDefaults.buttonColors(containerColor = error2)
//            ) {
//                Text("1412")
//            }
//        }
//        Row {
//            Button(
//                onClick = { error3 = Color.Red },
//                colors = ButtonDefaults.buttonColors(containerColor = error3)
//            ) {
//                Text("1714")
//            }
//            Spacer(Modifier.width(10.dp))
//
//            Button(
//                onClick = {
//                    correcte = Color.Green
//                    navigateToAnswer()
//                },
//                colors = ButtonDefaults.buttonColors(containerColor = correcte)
//            ) {
//                Text("1492")
//
//            }
*/        }
    }


/*@Composable
fun Quiz2(navigateToQuiz3: () -> Unit) {
    var error1 by remember { mutableStateOf(Color.Gray) }
    var error2 by remember { mutableStateOf(Color.Gray) }
    var error3 by remember { mutableStateOf(Color.Gray) }
    var correcte by remember { mutableStateOf(Color.Gray) }


    Column(
        modifier = Modifier.fillMaxSize().background(Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(20.dp))
        Text("Round 2/15")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Qui ha guanyat el mundial de futbol 2022?", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(50.dp))
        Row {
            Button(
                onClick = { error1 = Color.Red },
                colors = ButtonDefaults.buttonColors(containerColor = error1)
            ) {
                Text("França")
            }
            Spacer(Modifier.width(10.dp))

            Button(onClick = {
                correcte = Color.Green
                navigateToQuiz3()},
                colors = ButtonDefaults.buttonColors(containerColor = correcte)) {
                Text("Argentina")

            }


        }
        Row {
            Button(
                onClick = { error2 = Color.Red },
                colors = ButtonDefaults.buttonColors(containerColor = error2)
            ) {
                Text("Alemanya")
            }
            Spacer(Modifier.width(10.dp))

            Button(
                onClick = { error3 = Color.Red },
                colors = ButtonDefaults.buttonColors(containerColor = error3)
            ) {
                Text("Anglaterra")
            }
        }
    }
}
*/

object Trivial {
    @Serializable
    data object Menu

    @Serializable
    data object Settings

    @Serializable
    data object Quiz

    @Serializable
    data object Answer
}

data class Pregunta(
    val text: String,
    val respostes: List<String>,
    val respostacorrecta: Int
)

@Composable
fun TrivialGame() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Trivial.Menu) {

        composable<Trivial.Menu> {
            Trivial(
                navigateToSettings = { navController.navigate(Trivial.Settings) },
                navigateToGame = { navController.navigate(Trivial.Quiz) },
            )
        }
        composable<Trivial.Settings> {
            Settings(
                navigateToMenu = { navController.navigate(Trivial.Menu) },
            )
        }
        composable<Trivial.Quiz> {
            Quiz(
                navigateToAnswer = { navController.navigate(Trivial.Answer) },
            )
        }
        composable<Trivial.Answer> {
            Answer(
                navigateToMenu = { navController.navigate(Trivial.Menu) },
            )
        }
    }
}