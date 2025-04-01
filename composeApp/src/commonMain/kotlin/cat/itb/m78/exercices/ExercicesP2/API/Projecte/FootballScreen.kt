package cat.itb.m78.exercices.ExercicesP2.API.Projecte

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun FCBScreenMain() {
    val viewModel = viewModel { FootballViewModel() }
    val fcb = viewModel.fcb.value
    FCBscreen(fcb)
}

@Composable
fun FCBscreen(fcb: teams?) {
    if (fcb == null) {

        Column(
            modifier = Modifier.fillMaxSize().background(Color.Cyan),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize().background(Color.Green),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            for (teams in fcb.teams)
                item {
                    Row {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(teams.strTeam.toString())
                            Text("-----------------------------")
                            Text(teams.intFormedYear.toString())
                        }
                        Column {
                            Text("Actual Competitions: " + teams.strLeague.toString())
                            Text(teams.strLeague2.toString())
                            Text(teams.strLeague3.toString())
                            Text(teams.strLeague4.toString())
                            Text(teams.strLeague5.toString())
                            Text(teams.strLeague6.toString())
                            Text(teams.strLeague7.toString())

                        }
                    }
                }
        }
    }
}