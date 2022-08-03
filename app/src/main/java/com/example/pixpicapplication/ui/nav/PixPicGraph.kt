package com.example.pixpicapplication.ui.nav

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ScaffoldState
import androidx.compose.material3.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pixpicapplication.ui.gallery.GalleryScreen
import com.example.pixpicapplication.ui.home.HomeScreen
import com.example.pixpicapplication.ui.splash.SplashScreen

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
            GalleryScreen()
        }
    }
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