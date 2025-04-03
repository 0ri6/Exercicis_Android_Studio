package cat.itb.m78.exercices.ExercicesP2.API.Projecte

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FootballViewModel : ViewModel(){
    val fcb = mutableStateOf<teams?>(null)


    init {
        viewModelScope.launch(Dispatchers.Default) {
            fcb.value = FootballApi.listFootball()
        }
    }
}