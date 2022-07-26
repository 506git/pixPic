package com.example.pixpicapplication.ui.bottom

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.pixpicapplication.R

@Composable
fun SheetContent(
    heightFraction: Float = 0.9f,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.purple_200))
            .fillMaxWidth()
            .fillMaxHeight(fraction = heightFraction)
    ) {
        content()
    }
}