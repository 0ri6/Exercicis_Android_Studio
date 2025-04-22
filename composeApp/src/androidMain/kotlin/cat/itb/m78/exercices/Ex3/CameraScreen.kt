package cat.itb.m78.exercices.Ex3

import androidx.camera.compose.CameraXViewfinder
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil3.compose.rememberAsyncImagePainter

@Composable
fun CameraScreen(navController: NavController) {
    val viewModel = viewModel { CameraViewModel() }
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val capturedUri = viewModel.capturedImageUri.value

    LaunchedEffect(lifecycleOwner) {
        viewModel.bindToCamera(context.applicationContext, lifecycleOwner)
    }

    if (capturedUri != null) {
        // 📸 Mostrar la imagen capturada
        Image(
            painter = rememberAsyncImagePainter(capturedUri),
            contentDescription = "Foto capturada",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Button(
            onClick = { navController.popBackStack() },
            //modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 120.dp)
        ) {
            Text("Back")
        }
    } else {
        // 🎥 Mostrar la cámara
        val surfaceRequest = viewModel.surferRequest.value
        val imageCaptureUseCase = viewModel.imageCaptureUseCase
        surfaceRequest?.let { request ->
            Box {
                CameraXViewfinder(
                    surfaceRequest = request,
                    modifier = Modifier.fillMaxSize()
                )
                Button(
                    onClick = { takePhoto(context, imageCaptureUseCase, viewModel) },
                    modifier = Modifier.align(Alignment.BottomCenter).padding(50.dp)
                ) {
                    Text("Take Photo")
                }
            }
        }
    }
}
