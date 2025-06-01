package com.jo.itsme.ui.composable.restau

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.jo.itsme.data.DataService
import com.jo.itsme.model.Menu

@Composable
fun HomeScreen(onClick: (Menu) -> Unit) {
    LazyColumn(
        content = {
            items(DataService().allMenu) { menu ->
                MenuView(menu = menu, onClick = { onClick(it) })
            }
        }
    )
}