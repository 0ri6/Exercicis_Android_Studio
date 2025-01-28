package cat.itb.m78.exercices.Navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

sealed interface Screen {
    data object MainScreen : Screen
    data object Screen1 : Screen
    data object Screen2 : Screen
    data class Screen3(val message: String) : Screen
}

private class ManualNavAppViewModel : ViewModel() {
    val currentScreen = mutableStateOf<Screen>(Screen.MainScreen)
    fun navigateTo(screen: Screen) {
        currentScreen.value = screen
    }
}


@Composable
fun ManualNav() {
    val viewModel = viewModel { ManualNavAppViewModel() }
    val currentScreen = viewModel.currentScreen.value
    when (currentScreen) {
        Screen.MainScreen -> MainScreen(
            navigateToScreen1 = { viewModel.navigateTo(Screen.Screen1) },
            navigateToScreen2 = { viewModel.navigateTo(Screen.Screen2) },
            navigateToScreen3 = { viewModel.navigateTo(Screen.Screen3(it)) },
        )

        is Screen.Screen1 -> Screen1(
            navigateToScreen0 = { viewModel.navigateTo(Screen.MainScreen) }
        )

        is Screen.Screen2 -> Screen2(
            navigateToScreen0 = { viewModel.navigateTo(Screen.MainScreen) }
        )

        is Screen.Screen3 -> Screen3(
            navigateToScreen0 = { viewModel.navigateTo(Screen.MainScreen) },
            currentScreen.message

        )
    }
}

@Composable
fun MainScreen(
    navigateToScreen1: () -> Unit,
    navigateToScreen2: () -> Unit,
    navigateToScreen3: (String) -> Unit
) {
    Column {
        Button(onClick = { navigateToScreen1() }) {
            Text("Screen 1")
        }
        Button(onClick = { navigateToScreen2() }) {
            Text("Screen 2")
        }
        Button(onClick = { navigateToScreen3("Hello") }) {
            Text("Screen 3 - Hello")
        }
        Button(onClick = { navigateToScreen3("Bye") }) {
            Text("Screen 3 - Bye")
        }
    }
}

@Composable
fun Screen1(navigateToScreen0: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.Green),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text("Screen 1")
        Button(onClick = { navigateToScreen0() }) {
            Text("Main Menu")
        }
    }
}

@Composable
fun Screen2(navigateToScreen0: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.Red),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Screen 2")
        Button(onClick = { navigateToScreen0() }) {
            Text("Main Menu")
        }
    }
}


@Composable
fun Screen3(navigateToScreen0: () -> Unit, message: String) {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Screen 3")
        Text(message)
        Button(onClick = { navigateToScreen0() }) {
            Text("Main Menu")
        }
    }
}



