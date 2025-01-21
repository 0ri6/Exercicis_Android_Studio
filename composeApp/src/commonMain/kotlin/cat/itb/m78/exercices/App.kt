package cat.itb.m78.exercices


import androidx.compose.runtime.*
import cat.itb.m78.exercices.ExState.GoodMaN
import cat.itb.m78.exercices.ExState.HelloScreen
import cat.itb.m78.exercices.ExState.SecretNumber
import cat.itb.m78.exercices.ExState.gambling
import cat.itb.m78.exercices.ExStateless.Contact
import cat.itb.m78.exercices.ExStateless.Resource
import cat.itb.m78.exercices.ExStateless.Welcome
import cat.itb.m78.exercices.theme.AppTheme

@Composable
internal fun App() = AppTheme {
gambling()
}
