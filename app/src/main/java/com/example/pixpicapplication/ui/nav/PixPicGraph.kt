@file:OptIn(ExperimentalAnimationApi::class)

package com.example.pixpicapplication.ui.nav

import androidx.compose.animation.*
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ScaffoldState
import androidx.compose.material3.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pixpicapplication.ui.gallery.GalleryScreen
import com.example.pixpicapplication.ui.home.HomeScreen
import com.example.pixpicapplication.ui.splash.SplashScreen
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PixPicGraph(
    navController: NavHostController = rememberNavController(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    startDestination: String = MainDestination.SPLASH_ROUTE) {

    val context = LocalContext.current
    val actions = remember(navController){
        MainActions(navController)
    }

    NavHost(navController = navController, startDestination = startDestination){
        composable(MainDestination.HOME_ROUTE) {
            HomeScreen(goGallery = actions.goGallery)
        }
        composable(MainDestination.SPLASH_ROUTE){
            SplashScreen(goMain = actions.goMain)
        }
        composable(MainDestination.LOGIN_ROUTE){

        }
        composable(MainDestination.GALLERY_ROUTE){
            EnterAnimation{
                GalleryScreen()
            }
        }
    }
}

@Composable
fun EnterAnimation(content: @Composable () -> Unit) {
    var visible by remember { mutableStateOf(false) }
    AnimatedVisibility(
        visible = visible,
        enter = expandIn()
    ){
        content()
    }
    LaunchedEffect(key1 = Unit, block = {
        visible = true
    })
}

class MainActions(navController: NavController){
    val upPress : () -> Unit = {
        navController.navigateUp()
    }

    val goMain: () -> Unit = {
        navController.apply {
            popBackStack()
            navigate(MainDestination.HOME_ROUTE)
        }
    }

    val goHome : () -> Unit = {

    }

    val goGallery : () -> Unit = {
        navController.apply {
            navigate(MainDestination.GALLERY_ROUTE)
        }
    }

    val goBack : () -> Unit = {
        navController.popBackStack()
    }
}