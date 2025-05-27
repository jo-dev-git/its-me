package com.jo.itsme

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jo.itsme.ui.theme.ItsMeTheme

class PrincessActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            ItsMeTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ScaffoldComposable()
                }
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Preview(showBackground = true)
    @Composable
    fun ScaffoldComposable() {
        Scaffold(
            topBar = { Top() }, content = { Body() }
        )
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
                    modifier = Modifier.fillMaxWidth().height(50.dp)
                ) {
                    TextButton(onClick = { index = (0..4).random() }, modifier = Modifier.weight(1f)) {
                        Text("C'est parti !")
                    }
                    VerticalDivider(color = colorResource(R.color.white), modifier = Modifier.padding(0.dp, 2.dp))
                    IconButton(onClick = { index = 5 }, modifier = Modifier.weight(1f)) {
                        Icon(Icons.Default.Refresh, contentDescription = null)
                    }
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun Top() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.title_princess),
                fontSize = 22.sp,
                color = Color.White
            )
        },
    )
}

