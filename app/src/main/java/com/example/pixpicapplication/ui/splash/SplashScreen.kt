package com.example.pixpicapplication.ui.splash

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.example.pixpicapplication.R
import com.google.android.gms.common.SignInButton
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SplashScreen(goMain: () -> Unit) {
    var visible by remember { mutableStateOf(false)}
    val state = remember {
        MutableTransitionState(false).apply {
            // Start the animation immediately.
            targetState = true
        }
    }
    val animatedProgress = remember { Animatable(0f) }
    Scaffold() {
        Box(modifier = Modifier
            .background(colorResource(id = R.color.purple_200))
            .fillMaxSize()
            ){
            AnimatedVisibility(
//                visible = visible,
                visibleState = state,
                enter = slideInVertically(initialOffsetY = { -it},
                animationSpec = tween(durationMillis = 300, easing = LinearEasing))) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()) {
                    Box(modifier = Modifier
                        .height(80.dp)
                        .width(80.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(color = colorResource(id = R.color.white))
                    )
                    Text(text = "PixPic",
                        color = colorResource(id = R.color.white),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold)
                    Button(onClick = { /*TODO*/ },
                    modifier = Modifier.graphicsLayer (alpha = animatedProgress.value)) {

                    }

                }
            }

        }
        LaunchedEffect(key1 = Unit, block = {
            visible = true
            animatedProgress.animateTo(1f,
                animationSpec = tween(
                    durationMillis = 1000,
                    delayMillis = 400
                ))
            delay(1300L)
            goMain()
        })
    }
}

@Preview
@Composable
fun DefaultPreview(){
    SplashScreen() {}
}