package com.jo.itsme.ui.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.jo.itsme.data.all

@Composable
fun BodyComposable(paddingValues: PaddingValues) {
    // simple column
    //SimpleList(paddingValues, all)

    //Lazy column
    LazyList(paddingValues, all)
}