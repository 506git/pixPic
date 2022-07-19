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
import com.example.pixpicapplication.ui.bottom.SheetCollapsed
import com.example.pixpicapplication.ui.bottom.SheetContent
import com.example.pixpicapplication.ui.bottom.SheetExpanded

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
                SheetExpanded {
                    SheetExpandedContent(bottomSheetScaffoldState.currentFraction)
                }
                SheetCollapsed(
                    isCollapsed = bottomSheetScaffoldState.bottomSheetState.isCollapsed,
                    currentFraction = bottomSheetScaffoldState.currentFraction,
                ) {
                    SheetCollapsedContent(bottomSheetScaffoldState.currentFraction)
                }
            }
        },
        sheetPeekHeight = 150.dp
    ){
        Text(text = "${bottomSheetScaffoldState.currentFraction}")
//        MainContent()
    }
}

@Composable
fun SheetCollapsedContent(currentFraction: Float) {
    Column(modifier = Modifier
        .background(Color(0xffFDD835))
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

@Composable
fun SheetExpandedContent(currentFraction: Float){
    Column(modifier = Modifier
        .background(Color(0xffF00835))
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(start = 10.dp, top = 0.dp, end = 10.dp, bottom = 0.dp)
    ) {
        Text(text = "hi")
    }
}

@Composable
fun MainContent(){
    Column() {
        Text(text = "hi")
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