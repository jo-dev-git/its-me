package com.jo.itsme.ui.composable.strangers

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.jo.itsme.data.allPosts

@Composable
fun Body(paddingValues: PaddingValues) {
    Strangers(paddingValues, allPosts())
}