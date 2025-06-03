package com.jo.itsme.ui.composable.screen

import androidx.compose.runtime.Composable
import com.jo.itsme.data.allPosts
import com.jo.itsme.ui.composable.strangers.Strangers

@Composable
fun StrangersScreen() {
    Strangers(allPosts())
}
