package com.jo.itsme.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.jo.itsme.ui.composable.zoo.AppZoo
import com.jo.itsme.ui.theme.ItsMeTheme

class ZooActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ItsMeTheme {
                AppZoo()
            }
        }
    }
}