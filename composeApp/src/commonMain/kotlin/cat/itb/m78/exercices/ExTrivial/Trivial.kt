package cat.itb.m78.exercices.ExTrivial

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
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
import androidx.navigation.toRoute
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
fun Quiz(navigateToAnswer: (Int) -> Unit) {
    val preguntes = listOf(
        Pregunta("Com es diu el professor de llenguatge de marques?", listOf("Marc", "Juan", "Mateu", "Pere"), 2),
        Pregunta("Quina és la nota mitjana de programació?", listOf("1", "3", "5", "6"), 1),
        Pregunta("Qui és el delegat?", listOf("Yeray", "Eudald", "Laia", "Alvaro"), 0),
        Pregunta("Quin va ser el primer videojoc de la història?", listOf("Pong", "Space Invaders", "Tetris", "Tennis for Two"), 3),
        Pregunta("Quina empresa va desenvolupar la consola PlayStation?", listOf("Microsoft", "Sony", "Nintendo", "Sega"), 1),
        Pregunta("Quina és la unitat de mesura de la velocitat d'un processador?", listOf("GB", "MHz", "KB", "BMP"), 1),
        Pregunta("Quin joc va popularitzar el gènere Battle Royale?", listOf("Fortnite", "Apex Legends", "PlayerUnknown’s Battlegrounds (PUBG)", "Counter Strike Go (CSGo)"), 2),
        Pregunta("Quin d'aquests és un sistema operatiu?", listOf("Photoshop", "Windows", "Excel", "Firefox"), 1),
        Pregunta("Quina és la data de llançament de la primera Nintendo Entertainment System (NES)?", listOf("1983", "1990", "1985", "1979"), 0),
        Pregunta("Quin és el nom del creador de Minecraft?", listOf("Notch","Herobrine","John Carmack","Markus Persson"), 3),
        Pregunta("Quina d’aquestes targetes gràfiques és de la marca Nvidia?", listOf("Radeon", "Geforce", "Intel HD Graphics", "Vega"), 1),
        Pregunta("Quina és la màxima resolució d'alguns monitors 4K?", listOf("1920x1080", "3840x2160", "2560x1440","1280x720"), 1),
        Pregunta("Quin joc va ser desenvolupat per Blizzard Entertainment i és conegut per la seva batalla en línia entre herois?", listOf("World of Warcraft", "Overwatch", "Starcraft", "Diablo"), 1),
        Pregunta("Quin joc és el pitjor optimitzat de tots?", listOf("Ark", "Garten of Banban", "The Last of Us", "Cities: Skylines 2", "Totes són correctes"), 4),
        Pregunta("Quin és el joc més venut del món?", listOf("Tetris", "Minecraft", "GTA (Grand Thief Auto)", "Wii Sports"), 0),
    )


    var preguntaActualIndex by remember { mutableStateOf(0) }
    val preguntaActual = preguntes[preguntaActualIndex]

    var respostaSeleccionadaIndex by remember { mutableStateOf(-1) }
    var esRespostaCorrecta by remember { mutableStateOf(false) }
    var jaContestada by remember { mutableStateOf(false) }
    var respostesCorrectes by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize().background(Color.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(20.dp))
        Text("Ronda actual: ${preguntaActualIndex + 1}/15")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            preguntaActual.text,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(50.dp))

        preguntaActual.respostes.forEachIndexed { index, resposta ->
            val estaSeleccionada = respostaSeleccionadaIndex == index
            val colorBotó = when {
                jaContestada && index == preguntaActual.respostacorrecta -> Color.Green
                jaContestada && index != preguntaActual.respostacorrecta -> Color.Red
                else -> Color.Gray
            }

            Button(
                onClick = {
                    respostaSeleccionadaIndex = index
                    jaContestada = true
                    esRespostaCorrecta = index == preguntaActual.respostacorrecta
                    if (esRespostaCorrecta) {
                        respostesCorrectes++
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorBotó)
            ) {
                Text(text = resposta)
            }
        }

        Spacer(Modifier.height(20.dp))

        if (jaContestada) {
            if (preguntaActualIndex == preguntes.size - 1) {
                Button(
                    onClick = { navigateToAnswer(respostesCorrectes) }
                ) {
                    Text("Finalitzar Joc")
                }
            } else {
                Button(
                    onClick = {
                        preguntaActualIndex++
                        respostaSeleccionadaIndex = -1
                        jaContestada = false
                    }
                ) {
                    Text("Següent pregunta")
                }
            }
        }
    }
}

@Composable
fun Answer(respostesCorrectes: Int, navigateToMenu: () -> Unit) {
    val totalPreguntes = 15

    Column(
        modifier = Modifier.fillMaxSize().background(Color.Cyan),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Respostes correctes: $respostesCorrectes/$totalPreguntes",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(20.dp))

        Button(onClick = { navigateToMenu() }) {
            Text("Tornar al menú")
        }
    }
}

@Composable
fun Settings(navigateToMenu: () -> Unit) {
    var dificultat by remember { mutableStateOf("Normal") }
    var rondes by remember { mutableStateOf(10) }
    var tempsPerRonda by remember { mutableStateOf(30f) }
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().background(Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Configuració", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(Modifier.height(20.dp))

        Text("Dificultat", fontSize = 18.sp, fontWeight = FontWeight.Medium)
        Box {
            Button(onClick = { expanded = true }) {
                Text(dificultat)
            }
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                listOf("Fàcil", "Normal", "Difícil").forEach { level ->
                    DropdownMenuItem(text = { Text(level) }, onClick = {
                        dificultat = level
                        expanded = false
                    })
                }
            }
        }

        Spacer(Modifier.height(20.dp))

        Text("Rondes", fontSize = 18.sp, fontWeight = FontWeight.Medium)
        Row(verticalAlignment = Alignment.CenterVertically) {
            listOf(5, 10, 15).forEach { num ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = rondes == num, onClick = { rondes = num })
                    Text(num.toString())
                    Spacer(Modifier.width(8.dp))
                }
            }
        }

        Spacer(Modifier.height(20.dp))

        Text("Temps per ronda", fontSize = 18.sp, fontWeight = FontWeight.Medium)
        Slider(
            value = tempsPerRonda,
            onValueChange = { tempsPerRonda = it },
            valueRange = 10f..60f,
            steps = 4
        )
        Text("${tempsPerRonda.toInt()} segons")

        Spacer(Modifier.height(20.dp))

        Button(onClick = { navigateToMenu() }) {
            Text("Tornar al menú")
        }
    }
}


object Trivial {
    @Serializable
    data object Menu

    @Serializable
    data object Settings

    @Serializable
    data object Quiz

    @Serializable
    data class Answer(val respostesCorrectes: Int)

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
                navigateToAnswer = { navController.navigate(Trivial.Answer(it)) },
            )
        }
        composable<Trivial.Answer> { backStack ->
            val respostesCorrectes = backStack.toRoute<Trivial.Answer>().respostesCorrectes
            Answer(
                navigateToMenu = { navController.navigate(Trivial.Menu) },
                respostesCorrectes = respostesCorrectes
            )
        }
    }
}