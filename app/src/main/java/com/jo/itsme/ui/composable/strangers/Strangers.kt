package com.jo.itsme.ui.composable.strangers

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.jo.itsme.model.Post

@Composable
fun Strangers(posts: List<Post>) {
    LazyColumn {
        items(posts) {
            StrangerItem(post = it)
        }
    }
}