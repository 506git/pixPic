package com.example.pixpicapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pixpicapplication.ui.PixPicGraph
import com.example.pixpicapplication.ui.theme.PixPicApplicationTheme
import timber.log.Timber

class MainActivity : ComponentActivity() {
    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PixPicApplicationTheme {
                var navController = rememberNavController()
                var coroutineScope = rememberCoroutineScope()

                val scaffoldState = rememberScaffoldState()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                Scaffold(scaffoldState = scaffoldState) {
                    PixPicGraph(
                        navController = navController,
                        scaffoldState = scaffoldState
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PixPicApplicationTheme {
        Greeting("Android")
    }
}