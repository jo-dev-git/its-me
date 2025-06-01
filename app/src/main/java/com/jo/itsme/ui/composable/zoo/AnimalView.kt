package com.jo.itsme.ui.composable.zoo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jo.itsme.model.Animal

@Composable
fun AnimalView(animal: Animal) {
    Card(
        elevation = CardDefaults.cardElevation(7.dp),
        shape = RoundedCornerShape(10.dp),
    ) {
        Column {
            Image(
                painterResource(animal.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height((LocalConfiguration.current.screenWidthDp / 2).dp)
            )
            Text(
                animal.name,
                textAlign = TextAlign.Center,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, bottom = 5.dp)
            )
        }

    }
}