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
import com.example.pixpicapplication.R

@Composable
fun SheetCollapsedContent() {
    val context = LocalContext.current
    val actions = remember(){
        ItemActions(context)
    }
    Column(Modifier.background(MaterialTheme.colors.background)) {
        TextField(value = "hi", onValueChange = {}, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(start = 20.dp, top = 0.dp, end = 20.dp, bottom = 0.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            ActiveButton("photo", painterResource(id = R.drawable.btn_gallery), actions.photo)
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
            Text(text = title, fontSize = 12.sp)
        }
    }
}


class ItemActions(context: Context){
    val photo : () -> Unit = {
        Toast.makeText(context,"photo",Toast.LENGTH_LONG).show()
    }

    val start : () -> Unit = {
        Toast.makeText(context,"start",Toast.LENGTH_LONG).show()
    }

    val reset : () -> Unit = {
        Toast.makeText(context,"reset",Toast.LENGTH_LONG).show()
    }
}

