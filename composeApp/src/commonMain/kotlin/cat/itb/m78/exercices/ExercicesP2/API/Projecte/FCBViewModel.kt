package cat.itb.m78.exercices.ExercicesP2.API.Projecte

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FCBViewModel : ViewModel(){
    val fcb = mutableStateOf<List<Barca>?>(null)

    init {
        viewModelScope.launch(Dispatchers.Default) {
            fcb.value = FCBApi().listFCB()
        }
    }
}