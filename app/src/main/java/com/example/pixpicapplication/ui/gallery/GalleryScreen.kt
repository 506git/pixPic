package com.example.pixpicapplication.ui.gallery

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun GalleryScreen() {
    Column(modifier = Modifier
        .background(Color.Gray)
        .fillMaxSize()){
        Text(text = "hi gallery")
        Text(text = "hi gallery")
        Text(text = "hi gallery")
        Box(modifier = Modifier.background(Color.Blue).fillMaxSize())
    }

}