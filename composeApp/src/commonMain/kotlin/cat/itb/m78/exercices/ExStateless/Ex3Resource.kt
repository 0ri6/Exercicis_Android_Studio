package cat.itb.m78.exercices.ExStateless

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.generatedFace
import org.jetbrains.compose.resources.painterResource

@Composable

fun Resource() {
    Column (
        modifier = Modifier.fillMaxSize().background(Color.Black)
    ) {
        Text(
            text = "This is a resource string!",
            fontSize = 15.sp,
            color = Color.White
        )
        Image(
            painter = painterResource(Res.drawable.generatedFace),
            modifier = Modifier.size(100.dp),
            contentDescription = null
        )
    }
}