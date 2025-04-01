package cat.itb.m78.exercices.ExercicesP2.API.Projecte

import cat.itb.m78.exercices.ExercicesP2.API.Jokes.Joke
import cat.itb.m78.exercices.ExercicesP2.API.Jokes.JokesViewModel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.unit.dp


@Composable
fun JokesScreen() {
    val viewModel = viewModel { JokesViewModel() }
    val joke = viewModel.joke.value
    JokesScreen(joke)
}

@Composable
fun JokesScreen(joke: Joke?) {
    if (joke == null) {
        Column(
            modifier = Modifier.fillMaxSize().background(Color.Cyan),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize().background(Color.Green),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(joke.setup, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(20.dp))
            Text(joke.punchline)

        }
    }
}