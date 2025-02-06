package cat.itb.m78.exercices.ExNavigation
/*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Composable
fun LibNav(
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
fun ScreenN1(navigateToScreen0: () -> Unit) {
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
fun ScreenN2(navigateToScreen0: () -> Unit) {
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
fun ScreenN3(navigateToScreen0: () -> Unit, message: String) {
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

object Destination {
    @Serializable
    data object ScreenN1

    @Serializable
    data object ScreenN2

    @Serializable
    data object ScreenN3
}

@Composable
fun LibNavScreenSample() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Destination.ScreenN1) {
        composable<Destination.ScreenN1> {
            ScreenN1(
                navigateToScreen2 = { navController.navigate(Destination.ScreenN2) },
            )
        }
        composable<Destination.ScreenN2> {
            Screen2 { navController.navigate(Destination.ScreenN3(it)) }
        }
        composable<Destination.ScreenN3> { backStack ->
            val message = backStack.toRoute<Destination.ScreenN3>().message
            ScreenN3(message)
        }
    }
}*/