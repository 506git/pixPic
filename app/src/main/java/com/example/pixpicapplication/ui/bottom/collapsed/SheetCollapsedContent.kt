package com.example.pixpicapplication.ui.bottom.collapsed

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pixpicapplication.R
import com.example.pixpicapplication.ui.nav.MainActions
import com.example.pixpicapplication.ui.nav.MainDestination

@Composable
fun SheetCollapsedContent(goGallery: () -> Unit) {
    val context = LocalContext.current
    val navController: NavHostController = rememberNavController()
    val actions = remember(navController){
        ItemActions(context, navController)
    }

    val mainActions = remember(navController){
        MainActions(navController)
    }
    Column() {
        TextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth(), placeholder = { Text("Texxt hear") })
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(start = 20.dp, top = 0.dp, end = 20.dp, bottom = 0.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            ActiveButton("photo", painterResource(id = R.drawable.btn_gallery), goGallery)
            ActiveButton("start", painterResource(id = R.drawable.btn_on), actions.start)
            ActiveButton("reset", painterResource(id = R.drawable.btn_refresh), actions.reset)
        }
    }
}

@Composable
fun ActiveButton(title: String, painter: Painter, actions: () -> Unit){
    OutlinedButton(
        modifier = Modifier.size(dimensionResource(id = R.dimen.view_icon_size_width), dimensionResource(id = R.dimen.view_icon_size_height)),
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.bottom_icon_view)),
        contentPadding = PaddingValues(0.dp),
        elevation = ButtonDefaults.elevation(10.dp),
        onClick = { actions() },
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(modifier = Modifier.background(colorResource(id = R.color.bottom_icon_view))) {
            Icon(
                painter = painter,
                contentDescription = stringResource(id = R.string.btn_photo_desc),
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.icon_size))
                    .align(Alignment.CenterHorizontally),
                tint = Color.Unspecified
            )
            Text(text = title, fontSize = 12.sp, color = Color.Black)
        }
    }
}


class ItemActions(context: Context, navController : NavController){
    val photo : () -> Unit = {
        Toast.makeText(context,"photo",Toast.LENGTH_LONG).show()
        navController.apply {
            popBackStack()
            navigate(MainDestination.HOME_ROUTE)
        }
    }

    val start : () -> Unit = {
        Toast.makeText(context,"start",Toast.LENGTH_LONG).show()
    }

    val reset : () -> Unit = {
        Toast.makeText(context,"reset",Toast.LENGTH_LONG).show()
    }

    val test : () -> Unit = {
        navController.apply {
            navigate(MainDestination.GALLERY_ROUTE)
        }
    }
}

