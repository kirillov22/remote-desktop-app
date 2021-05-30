package com.kirillov.remote_desktop_app.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kirillov.remote_desktop_app.R
import com.kirillov.remote_desktop_app.model.Constants

@Composable
fun FullscreenButton() {
    MaterialTheme {
        Image(
            painter = painterResource(id = R.drawable.fullscreen),
            contentDescription = null,
            modifier = Modifier
                .width(Constants.BUTTON_SIZE.dp)
                .height(Constants.BUTTON_SIZE.dp)
                .border(BorderStroke(2.dp, Color.Gray))
                .clip(shape = RoundedCornerShape(4.dp))
                .clickable( onClick = { /*TODO*/ })
        )
    }
}