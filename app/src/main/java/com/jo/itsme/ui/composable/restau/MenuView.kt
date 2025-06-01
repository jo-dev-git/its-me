package com.jo.itsme.ui.composable.restau

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jo.itsme.model.Menu

@Composable
fun MenuView(menu: Menu, onClick: (Menu) -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height((LocalConfiguration.current.screenHeightDp / 3).dp)
            .padding(start = 4.dp, end = 4.dp, bottom = 4.dp)
            .clickable { onClick(menu) },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = menu.plat.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            contentScale = ContentScale.Crop
        )
        Surface(
            modifier = Modifier.clip(RoundedCornerShape(percent = 30)),
            color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.5F)
        ) {
            Text(
                text = menu.name,
                fontSize = 25.sp,
                modifier = Modifier.padding(15.dp)
            )
        }
    }
}