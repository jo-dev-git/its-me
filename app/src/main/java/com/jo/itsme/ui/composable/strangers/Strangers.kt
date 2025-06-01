package com.jo.itsme.ui.composable.strangers

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jo.itsme.data.Post

@Composable
fun Strangers(paddingValues: PaddingValues, posts: List<Post>) {
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
    ) {
        items(posts) {
            StrangerItem(post = it)
        }
    }
}