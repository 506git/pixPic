package com.example.pixpicapplication.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pixpicapplication.R

@Composable
fun ImageContent() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp)
        .padding(bottom = 125.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "hi")
        Spacer(modifier = Modifier.height(15.dp))
        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "mainImage",
            modifier = Modifier
                .heightIn(min = 225.dp, max = 375.dp)
                .widthIn(min = 225.dp, max = 375.dp)
                .background(colorResource(id = R.color.purple_500))
            )
    }

}