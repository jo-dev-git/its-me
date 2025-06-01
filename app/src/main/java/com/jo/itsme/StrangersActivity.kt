package com.jo.itsme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jo.itsme.ui.composable.strangers.ScaffoldApp
import com.jo.itsme.ui.theme.ItsMeTheme

class StrangersActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ItsMeTheme {
                ScaffoldApp()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultAppPreview() {
    ItsMeTheme {
        ScaffoldApp()
    }
}
