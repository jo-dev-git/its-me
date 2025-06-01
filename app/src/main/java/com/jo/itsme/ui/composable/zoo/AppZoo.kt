package com.jo.itsme.ui.composable.zoo

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jo.itsme.ui.composable.AppBarComposable
import com.jo.itsme.ui.composable.BodyComposable
import com.jo.itsme.ui.theme.ItsMeTheme


@Preview(showBackground = true)
@Composable
fun AppZoo() {
    Scaffold(
        topBar = { AppBarZoo() },
        content = { it: PaddingValues -> BodyZoo(it) }
    )
}

@Preview(showBackground = true)
@Composable
fun ScaffoldPreview() {
    ItsMeTheme {
        AppZoo()
    }
}