package com.jo.itsme

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jo.itsme.ui.theme.ItsMeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ItsMeTheme {
                ScaffoldComposable()
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun ScaffoldComposable() {
        Scaffold(
            topBar = {AppBar()},
            content = {Body("Mario")}
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AppBar() {
        TopAppBar(
            title = { Text(text = stringResource(R.string.title_top_bar),
                style= MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.tertiary)
                    },
            navigationIcon = {
                Image(painterResource(R.drawable.appstore),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .width(40.dp)
                        .height(40.dp)
                        .clip(MaterialTheme.shapes.small))
            }
        )
    }

    @Composable
    fun Body(name: String) {
        val localConfiguration = LocalConfiguration.current
        val width = localConfiguration.screenWidthDp
        val height = localConfiguration.screenHeightDp

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "It's me ! $name", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.tertiary)
            Surface(
                shadowElevation = 12.dp,
                modifier = Modifier
                    .width(width = (width * 0.66).dp),
                shape = MaterialTheme.shapes.small
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(
                        painterResource(R.drawable.profile),
                        contentDescription = stringResource(R.string.mario),
                        modifier = Modifier
                            .height((height / 5).dp)
                            .width((height / 5).dp)
                            .padding(25.dp)
                            .clip(MaterialTheme.shapes.large)
                    )
                    Text(
                        text = name,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(8.dp, 8.dp, 16.dp, 16.dp),
                        textAlign = TextAlign.Center)
                    HorizontalDivider()
                    Text(text = stringResource(R.string.mario_description))
                }
            }
            Spacer(modifier = Modifier)
        }
    }
}