package com.jo.itsme.ui.composable.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jo.itsme.R

@Composable
fun PrincessScreen() {
    Body()
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Body() {
    val local = LocalConfiguration.current
    val height = local.screenHeightDp
    val width = local.screenWidthDp

    var index by remember { androidx.compose.runtime.mutableIntStateOf(5) }

    fun getPrincess(): Pair<String, Int> {
        // Can extract strings here
        return when (index) {
            0 -> "Elsa" to R.drawable.elsa
            1 -> "Merida" to R.drawable.merida
            2 -> "Mirabel" to R.drawable.mirabel
            3 -> "Pocahontas" to R.drawable.pocahontas
            4 -> "Raiponce" to R.drawable.raiponce
            else -> "encore personne" to R.drawable.all
        }
    }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painterResource(getPrincess().second), contentDescription = null,
            modifier = Modifier
                .height((height / 2).dp)
                .width((width * 0.8).dp)
                .padding(20.dp)
                .clip(RoundedCornerShape(5)),
            contentScale = ContentScale.Crop
        )
        Text("Vous êtes... ${getPrincess().first}")
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            HorizontalDivider(color = colorResource(R.color.white))
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                TextButton(onClick = { index = (0..4).random() }, modifier = Modifier.weight(1f)) {
                    Text("C'est parti !")
                }
                VerticalDivider(
                    color = colorResource(R.color.white),
                    modifier = Modifier.padding(0.dp, 2.dp)
                )
                IconButton(onClick = { index = 5 }, modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Refresh, contentDescription = null)
                }
            }
        }
    }
}


