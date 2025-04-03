package cat.itb.m78.exercices.ExercicesP2.API.Projecte

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage


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
                            Spacer(modifier = Modifier.height(10.dp))

                            Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
                                teams.strBadge.toString()
                                AsyncImage(
                                    model = teams.strBadge,
                                    contentDescription = "NULL",
                                    modifier = Modifier.absolutePadding(left = 0.dp).size(75.dp)
                                )
                                Text(
                                    text = "${teams.strTeam} (${teams.intFormedYear})",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 23.sp
                                )

                            }
                            teams.strEquipment.toString()
                            AsyncImage(
                                model = teams.strEquipment,
                                contentDescription = "NULL",
                                modifier = Modifier.absolutePadding(left = 0.dp).size(75.dp)
                            )
                            Spacer(modifier = Modifier.height(10.dp))

                            Text("\uD83C\uDFC6Actual Competitions\uD83C\uDFC6: ", fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.height(10.dp))

                            teams.strLeagues.forEach {
                                Text(it)
                            }
                            Spacer(modifier = Modifier.height(25.dp))

                            Text("\uD83C\uDFDF\uFE0FStadium\uD83C\uDFDF\uFE0F: ", fontWeight = FontWeight.Bold)
                            Text(teams.strStadium.toString())
                            Spacer(modifier = Modifier.height(25.dp))

                            Text("\uD83D\uDC65Capacity\uD83D\uDC65: ", fontWeight = FontWeight.Bold)
                            Text(teams.intStadiumCapacity.toString())
                            Spacer(modifier = Modifier.height(25.dp))

                            Text("⚽Keyword⚽: ", fontWeight = FontWeight.Bold)
                            Text(teams.strKeywords.toString())
                            Spacer(modifier = Modifier.height(25.dp))

                            Text("\uD83D\uDCCCLocation\uD83D\uDCCC: ", fontWeight = FontWeight.Bold)
                            Text(teams.strLocation.toString())
                            Spacer(modifier = Modifier.height(25.dp))

                            Text("\uD83C\uDF10Website\uD83C\uDF10: ", fontWeight = FontWeight.Bold)
                            Text(teams.strWebsite.toString())
                            Spacer(modifier = Modifier.height(25.dp))

                            Text("\uD83D\uDC26Social Media\uD83D\uDC26: ", fontWeight = FontWeight.Bold)
                            teams.SocialMedia.forEach {
                                Text(it)
                            }
                            Spacer(modifier = Modifier.height(25.dp))

                            Text("\uD83D\uDCACDescription\uD83D\uDCAC: ", fontWeight = FontWeight.Bold)
                            teams.Descriptions.forEach {
                                Text(it)
                            }
                            Spacer(modifier = Modifier.height(25.dp))

                            teams.strFanart1.toString()
                            AsyncImage(
                                model = teams.strFanart1,
                                contentDescription = "NULL",
                                modifier = Modifier.absolutePadding(left = 0.dp). size(300.dp)
                            )

                            teams.strFanart2.toString()
                            AsyncImage(
                                model = teams.strFanart2,
                                contentDescription = "NULL",
                                modifier = Modifier.absolutePadding(left = 0.dp). size(300.dp)
                            )
                            teams.strFanart3.toString()
                            AsyncImage(
                                model = teams.strFanart3,
                                contentDescription = "NULL",
                                modifier = Modifier.absolutePadding(left = 0.dp). size(300.dp)
                            )
                            teams.strFanart4.toString()
                            AsyncImage(
                                model = teams.strFanart4,
                                contentDescription = "NULL",
                                modifier = Modifier.absolutePadding(left = 0.dp). size(300.dp)
                            )
                            Spacer(modifier = Modifier.height(25.dp))
                        }
                    }
                }
        }
    }
}