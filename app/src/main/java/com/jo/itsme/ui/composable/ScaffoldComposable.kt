package com.jo.itsme.ui.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jo.itsme.ui.theme.ItsMeTheme


@Preview(showBackground = true)
@Composable
fun ScaffoldComposable() {
    Scaffold(
        topBar = { AppBarComposable() },
        content = { it: PaddingValues -> BodyComposable(it) }
    )
}

@Preview(showBackground = true)
@Composable
fun ScaffoldPreview() {
    ItsMeTheme {
        ScaffoldComposable()
    }
}