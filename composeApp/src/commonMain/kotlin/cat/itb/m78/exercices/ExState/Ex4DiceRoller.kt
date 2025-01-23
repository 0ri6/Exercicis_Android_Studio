package cat.itb.m78.exercices.ExState

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.dice_1
import m78exercices.composeapp.generated.resources.dice_2
import m78exercices.composeapp.generated.resources.dice_3
import m78exercices.composeapp.generated.resources.dice_4
import m78exercices.composeapp.generated.resources.dice_5
import m78exercices.composeapp.generated.resources.dice_6
import m78exercices.composeapp.generated.resources.tapestry
import m78exercices.composeapp.generated.resources.title
import org.jetbrains.compose.resources.painterResource
import kotlin.random.Random

@Composable
fun gambling() {


    val randomnumber1 = mutableStateOf(Random.nextInt(1, 7))
    val randomnumber2 = mutableStateOf(Random.nextInt(1, 7))
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }


    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
    )
    { padding ->
        Image(
            painter = painterResource(Res.drawable.tapestry),
            modifier = Modifier.fillMaxSize(),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {

            Image(
                painter = painterResource(Res.drawable.title),
                modifier = Modifier.size(250.dp),
                contentDescription = null,
            )

            Button(modifier = Modifier.padding(padding), onClick = {
                randomnumber1.value = Random.nextInt(1, 7)
                randomnumber2.value = Random.nextInt(1, 7)
                scope.launch {
                    if (randomnumber1.value == 6 && randomnumber2.value == 6) {
                        snackbarHostState.showSnackbar("JACKPOT!!")
                    }
                }
            }) {
                Text("ROLL THE DICE!!")
            }


            Row {

                if (randomnumber1.value == 1) {
                    pedo1()
                } else {
                    if (randomnumber1.value == 2) {
                        pedo2()
                    } else {
                        if (randomnumber1.value == 3) {
                            pedo3()
                        } else {
                            if (randomnumber1.value == 4) {
                                pedo4()
                            } else {
                                if (randomnumber1.value == 5) {
                                    pedo5()
                                } else {
                                    if (randomnumber1.value == 6) {
                                        pedo6()
                                    }
                                }
                            }
                        }
                    }
                }

                if (randomnumber2.value == 1) {
                    pedo1()
                } else {
                    if (randomnumber2.value == 2) {
                        pedo2()
                    } else {
                        if (randomnumber2.value == 3) {
                            pedo3()
                        } else {
                            if (randomnumber2.value == 4) {
                                pedo4()
                            } else {
                                if (randomnumber2.value == 5) {
                                    pedo5()
                                } else {
                                    if (randomnumber2.value == 6) {
                                        pedo6()
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }


}


@Composable
fun pedo1() {
    Image(
        painter = painterResource(Res.drawable.dice_1),
        modifier = Modifier.size(200.dp),
        contentDescription = null,
    )
}

@Composable
fun pedo2() {
    Image(
        painter = painterResource(Res.drawable.dice_2),
        modifier = Modifier.size(200.dp),
        contentDescription = null,
    )
}

@Composable
fun pedo3() {
    Image(
        painter = painterResource(Res.drawable.dice_3),
        modifier = Modifier.size(200.dp),
        contentDescription = null,
    )
}

@Composable
fun pedo4() {
    Image(
        painter = painterResource(Res.drawable.dice_4),
        modifier = Modifier.size(200.dp),
        contentDescription = null,
    )
}

@Composable
fun pedo5() {
    Image(
        painter = painterResource(Res.drawable.dice_5),
        modifier = Modifier.size(200.dp),
        contentDescription = null,
    )
}

@Composable
fun pedo6() {
    Image(
        painter = painterResource(Res.drawable.dice_6),
        modifier = Modifier.size(200.dp),
        contentDescription = null,
    )
}