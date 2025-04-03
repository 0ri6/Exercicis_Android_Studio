package cat.itb.m78.exercices.ExercicesP2.API.Projecte

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable

data class teams(
    val teams: List<Barca>
)

@Serializable
data class Barca    (
    val idTeam: String?,
    val idESPN: String?,
    val idAPIfootball: String?,
    val intLoved: String?,
    val strTeam: String?,
    val strTeamAlternate: String?,
    val strTeamShort: String?,
    val intFormedYear: String?,
    val strSport: String?,
    val strLeague: String?,
    val idLeague: String?,
    val strLeague2: String?,
    val idLeague2: String?,
    val strLeague3: String?,
    val idLeague3: String?,
    val strLeague4: String?,
    val idLeague4: String?,
    val strLeague5: String?,
    val idLeague5: String?,
    val idLeague6: String?,
    val strLeague6: String?,
    val idLeague7: String?,
    val strLeague7: String?,
    val idVenue: String?,
    val strStadium: String?,
    val strKeywords: String?,
    val strLocation: String?,
    val intStadiumCapacity: String?,
    val strWebsite: String?,
    val strFacebook: String?,
    val strTwitter: String?,
    val strInstagram: String?,
    val strDescriptionEN: String?,
    val strDescriptionIT: String?,
    val strDescriptionES: String?,
    val strDescriptionDE: String?,
    val strDescriptionFR: String?,
    val strDescriptionJP: String?,
    val strDescriptionCN: String?,
    val strDescriptionRU: String?,
    val strDescriptionPT: String?,
    val strDescriptionSE: String?,
    val strDescriptionNL: String?,
    val strDescriptionHU: String?,
    val strDescriptionNO: String?,
    val strDescriptionIL: String?,
    val strDescriptionPL: String?,
    val strColour1: String?,
    val strColour2: String?,
    val strGender: String?,
    val strCountry: String?,
    val strBadge: String?,
    val strLogo: String?,
    val strFanart1: String?,
    val strFanart2: String?,
    val strFanart3: String?,
    val strFanart4: String?,
    val strBanner: String?,
    val strEquipment: String?,
    val strYoutube: String?,
    val strLocked: String?
    ){

    val strLeagues = listOf(
        strLeague,
        strLeague2,
        strLeague3,
        strLeague4,
        strLeague5,
        strLeague6,
        strLeague7,
    ).filterNotNull().filter { it.isNotBlank() }

    val SocialMedia = listOf(
        strFacebook,
        strTwitter,
        strInstagram,
        strYoutube,
    ).filterNotNull().filter { it.isNotBlank() }

    val Descriptions = listOf(
        strDescriptionEN,
        strDescriptionIT,
        strDescriptionES,
        strDescriptionDE,
        strDescriptionFR,
        strDescriptionJP,
        strDescriptionCN,
        strDescriptionRU,
        strDescriptionPT,
        strDescriptionSE,
        strDescriptionNL,
        strDescriptionHU,
        strDescriptionNO,
        strDescriptionIL,
        strDescriptionPL,
    ).filterNotNull().filter { it.isNotBlank() }

}

object FootballApi {
    private val url = "https://www.thesportsdb.com/api/v1/json/3/search_all_teams.php?l=English%20Premier%20League"
    private val client = HttpClient(){
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }
    suspend fun listFootball() = client.get(url).body<teams>()

}