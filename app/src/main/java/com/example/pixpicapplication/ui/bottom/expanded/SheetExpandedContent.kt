package com.example.pixpicapplication.ui.bottom.expanded

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SheetExpandedContent() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colors.background)
        .fillMaxHeight()
        .padding(start = 10.dp, top = 0.dp, end = 10.dp, bottom = 0.dp)
    ) {
        Button(onClick = {}) {

        }
        Text(text = "hi", fontSize = 20.sp)
    }
}