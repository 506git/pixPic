package com.example.pixpicapplication.ui.splash

import android.content.res.Configuration
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.UiMode
import com.example.pixpicapplication.R
import com.example.pixpicapplication.ui.SignInButton
import com.example.pixpicapplication.ui.theme.PixPicApplicationTheme
import com.example.pixpicapplication.utils.AuthResultContract
import com.example.pixpicapplication.viewmodel.AuthViewModel
import com.google.android.gms.common.api.ApiException
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun SplashScreen(goMain: () -> Unit, authViewModel: AuthViewModel) {
//    var visible by remember { mutableStateOf(false)}
    val user by remember(authViewModel) { authViewModel.user }.collectAsState()
    val signInRequestCode = 1
    val coroutineScope = rememberCoroutineScope()
    var text by remember { mutableStateOf<String?>(null) }
    var isLoading by remember { mutableStateOf(false) }
    val animatedProgress = remember { Animatable(0f) }

    val authResultLauncher =
        rememberLauncherForActivityResult(contract = AuthResultContract()) { task ->
            try {
                val account = task?.getResult(ApiException::class.java)
                if (account == null) {
                    text = "Google sign in failed"
                } else {
                    coroutineScope.launch {
                        authViewModel.signIn(
                            email = account.email!!,
                            displayName = account.displayName!!,
                        )
                    }
                }
            } catch (e: ApiException) {
                text = "Google sign in failed"
            }
        }


    val state = remember {
        MutableTransitionState(false).apply {
            // Start the animation immediately.
            targetState = true
        }
    }

    Scaffold() {
        Box(modifier = Modifier
            .background(MaterialTheme.colors.surface)
            .fillMaxSize()
            ){
            AnimatedVisibility(
                visibleState = state,
                enter = slideInVertically(initialOffsetY = { -it},
                animationSpec = tween(durationMillis = 300, easing = LinearEasing))) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()) {
                    Image(
                        painter = painterResource(id = R.drawable.pic_icon),
                        contentDescription = "icon",
                        modifier = Modifier
                            .fillMaxSize(0.5f)
                        ,
                        contentScale = ContentScale.Crop,
                        colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onSurface)
                    )

                    SignInButton(text = "Sign in with Google",
                        loadingText = "Signing in...",
                        isLoading = isLoading,
                        icon = painterResource(id = R.drawable.ic_google_logo),
                        onClick = {
                            isLoading = true
                            authResultLauncher.launch(signInRequestCode)
                    })
                }
            }

        }

        LaunchedEffect(key1 = Unit, block = {
            Log.d("test", user?.displayName.toString())
            if(user != null){
                animatedProgress
                delay(500L)
                goMain()
            } else
            animatedProgress.animateTo(1f,
                animationSpec = tween(
                    durationMillis = 1000,
                    delayMillis = 400
            ))
//            delay(1300L)
//            goMain()
        })
    }
}

@Preview
@Composable
fun DefaultPreview(){
//    SplashScreen() {}
}
