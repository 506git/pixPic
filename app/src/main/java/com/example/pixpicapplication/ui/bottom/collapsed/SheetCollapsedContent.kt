package com.example.pixpicapplication.ui.bottom.collapsed

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SheetCollapsedContent() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(start = 10.dp, top = 0.dp, end = 10.dp, bottom = 0.dp)
    ) {
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedButton(onClick = { /*TODO*/ }) {

        }
        OutlinedButton(onClick = { /*TODO*/ }) {

        }
        OutlinedButton(onClick = { /*TODO*/ }) {

        }
    }
}