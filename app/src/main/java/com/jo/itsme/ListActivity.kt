package com.jo.itsme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jo.itsme.ui.composable.ScaffoldComposable
import com.jo.itsme.ui.theme.ItsMeTheme

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ItsMeTheme {
                ScaffoldComposable()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ItsMeTheme {
        ScaffoldComposable()
    }
}
