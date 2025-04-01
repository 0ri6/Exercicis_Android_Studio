package cat.itb.m78.exercices.ExercicesP2.API.Projecte

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Barca(
    val idTeam: String,
    val idESPN: String,
    val idAPIfootball: String,
    val intLoved: String,
    val strTeam: String,
    val strTeamAlternate: String,
    val strTeamShort: String,
    val intFormedYear: String,
    val strSport: String,
    val strLeague: String,
    val idLeague: String,
    val strLeague2: String,
    val idLeague2: String,
    val strLeague3: String,
    val idLeague3: String,
    val strLeague4: String,
    val idLeague4: String,
    val strLeague5: String,
    val idLeague5: String,
    val idVenue: String,
    val strStadium: String,
    val strKeywords: String,
    val strLocation: String,
    val intStadiumCapacity: String,
    val strWebsite: String,
    val strFacebook: String,
    val strTwitter: String,
    val strInstagram: String,
    val strDescriptionEN: String,
    val strDescriptionIT: String,
    val strDescriptionES: String,
    val strColour1: String,
    val strColour2: String,
    val strGender: String,
    val strCountry: String,
    val strBadge: String,
    val strLogo: String,
    val strFanart1: String,
    val strFanart2: String,
    val strFanart3: String,
    val strFanart4: String,
    val strBanner: String,
    val strEquipment: String,
    val strYoutube: String,
    val strLocked: String,



    )

class FCBAPi {
    private val url = "https://www.thesportsdb.com/api/v1/json/3/searchteams.php?t=Barcelona"
    private val client = HttpClient(){
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }
    suspend fun listFCB() = client.get(url).body<List<Barca>>()
}