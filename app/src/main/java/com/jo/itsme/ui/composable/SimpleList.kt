package com.jo.itsme.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jo.itsme.model.Message
import com.jo.itsme.ui.theme.ItsMeTheme

@Composable
fun SimpleList(paddingValues: PaddingValues, messages: List<Message>) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .verticalScroll(
                enabled = true,
                state = rememberScrollState()
            )
    ) {
        for (message in messages) {
            ListTile(message)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleListPreview() {
    ItsMeTheme {
        //SimpleList(paddingValues = paddingValues, messages = all)
    }
}