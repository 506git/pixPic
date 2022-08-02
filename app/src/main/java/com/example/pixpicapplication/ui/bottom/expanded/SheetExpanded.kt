package com.example.pixpicapplication.ui.bottom.expanded

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer

@Composable
fun SheetExpanded(currentFraction: Float, content: @Composable RowScope.() -> Unit) {
    Row(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.background)
        .graphicsLayer(alpha = currentFraction),
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}

