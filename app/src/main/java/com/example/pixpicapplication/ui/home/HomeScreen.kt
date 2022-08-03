package com.example.pixpicapplication.ui.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pixpicapplication.ui.bottom.collapsed.SheetCollapsed
import com.example.pixpicapplication.ui.bottom.SheetContent
import com.example.pixpicapplication.ui.bottom.expanded.SheetExpanded
import com.example.pixpicapplication.ui.bottom.collapsed.SheetCollapsedContent
import com.example.pixpicapplication.ui.bottom.expanded.SheetExpandedContent
import com.example.pixpicapplication.ui.theme.PixPicApplicationTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(goGallery: () -> Unit) {
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
        backgroundColor = MaterialTheme.colors.surface,
        sheetBackgroundColor = MaterialTheme.colors.background,
        sheetContent = {
            SheetContent {
                SheetCollapsed(
                    isCollapsed = bottomSheetScaffoldState.bottomSheetState.isCollapsed,
                    currentFraction = bottomSheetScaffoldState.currentFraction,
                ) {
                    SheetCollapsedContent(goGallery)
                }
                SheetExpanded(currentFraction = bottomSheetScaffoldState.currentFraction) {
                    SheetExpandedContent()
                }

            }
        },
        sheetPeekHeight = 170.dp
    ) {
        ImageContent()
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun prevHomeScreen() {
    PixPicApplicationTheme(darkTheme = false) {
        HomeScreen {}
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun prevDarkHomeScreen() {
    PixPicApplicationTheme(darkTheme = true) {
        HomeScreen {}
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