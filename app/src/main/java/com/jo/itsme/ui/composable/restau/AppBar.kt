package com.jo.itsme.ui.composable.restau

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jo.itsme.R
import com.jo.itsme.model.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    screens: Screens,
    canGoBack: Boolean,
    goBack: () -> Unit
) {
    TopAppBar(
        title = { Text(text = if (canGoBack) screens.title else "Mon Resto") },
        navigationIcon = {
            if (canGoBack) {
                IconButton(onClick = goBack) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            } else {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(CircleShape)
                )
            }
        }
    )
}