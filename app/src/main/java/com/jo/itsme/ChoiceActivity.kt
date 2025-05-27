package com.jo.itsme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jo.itsme.ui.theme.ItsMeTheme

class ChoiceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ItsMeTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Body()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun Body() {

        val list = listOf("Matthieu", "Jo", "Sylvain", "Marie", "José")
        var color by remember { mutableStateOf(Color.White) }
        var count by remember { mutableStateOf(0) }
        var index by remember { mutableStateOf(0) }

        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Apprendre les boutons avec ${list[index]}", color = color)
            Text("count = $count", color = color)
            Button(
                shape = MaterialTheme.shapes.medium,
                //border = BorderStroke(width = 2.dp, color = color),
                elevation = ButtonDefaults.buttonElevation(12.dp, pressedElevation = 0.dp),
                onClick = {
                    color = if (color == Color.Yellow) {
                        Color.Blue
                    } else {
                        Color.Yellow
                    }
                }
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                    Text("Mon premier bouton")
                }
            }
            TextButton(onClick = {
                count++
            }) {
                Text("Incrémenter")
            }
            IconButton(
                onClick = { count = 0 }
            ) {
                Icon(imageVector = Icons.Default.Done, contentDescription = null)
            }
            FloatingActionButton(onClick = {
                /**if (index < list.size -1)
                    index++
                else
                    index = 0**/
                index =(list.indices).random()
            }) {
                Icon(Icons.Default.Person, contentDescription = null)
            }
        }
    }
}
