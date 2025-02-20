package cat.itb.m78.exercices


import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import cat.itb.m78.exercices.ExStateless.Contact
import cat.itb.m78.exercices.ExTrivial.TrivialGame
import cat.itb.m78.exercices.ExViewModel.CounterStrike
import cat.itb.m78.exercices.Examen.Menu
import cat.itb.m78.exercices.theme.AppTheme

@Composable
internal fun App() = AppTheme {
    TrivialGame()
}
