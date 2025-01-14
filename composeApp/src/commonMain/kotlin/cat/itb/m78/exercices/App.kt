package cat.itb.m78.exercices


import androidx.compose.runtime.*
import cat.itb.m78.exercices.ExStateless.Contact
import cat.itb.m78.exercices.ExStateless.Resource
import cat.itb.m78.exercices.ExStateless.Welcome
import cat.itb.m78.exercices.theme.AppTheme

@Composable
internal fun App() = AppTheme {
Contact()
}
