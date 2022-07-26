package com.example.pixpicapplication.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pixpicapplication.ui.bottom.SheetCollapsed
import com.example.pixpicapplication.ui.bottom.SheetContent
import com.example.pixpicapplication.ui.bottom.SheetExpanded
import com.example.pixpicapplication.ui.bottom.collapsed.SheetCollapsedContent
import com.example.pixpicapplication.ui.bottom.expanded.SheetExpandedContent

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun HomeScreen() {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    val coroutineScope = rememberCoroutineScope()
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetShape = RoundedCornerShape(
            bottomStart = 0.dp,
            bottomEnd = 0.dp,
            topStart = 15.dp,
            topEnd = 15.dp
        ),
        sheetElevation = 8.dp,
        sheetContent = {
            SheetContent {
                SheetExpanded(currentFraction = bottomSheetScaffoldState.currentFraction) {
                    SheetExpandedContent()
                }
                SheetCollapsed(
                    isCollapsed = bottomSheetScaffoldState.bottomSheetState.isCollapsed,
                    currentFraction = bottomSheetScaffoldState.currentFraction,
                ) {
                    SheetCollapsedContent()
                }
            }
        },
        sheetPeekHeight = 150.dp
    ){
        ImageContent()
    }
}

@OptIn(ExperimentalMaterialApi::class)
val BottomSheetScaffoldState.currentFraction: Float
    get() {
        val fraction = bottomSheetState.progress.fraction
        val targetValue = bottomSheetState.targetValue
        val currentValue = bottomSheetState.currentValue

        return when {
            currentValue == BottomSheetValue.Collapsed && targetValue == BottomSheetValue.Collapsed -> 0f
            currentValue == BottomSheetValue.Expanded && targetValue == BottomSheetValue.Expanded -> 1f
            currentValue == BottomSheetValue.Collapsed && targetValue == BottomSheetValue.Expanded -> fraction
            else -> 1f - fraction
        }
    }