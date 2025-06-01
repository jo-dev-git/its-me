package com.jo.itsme.ui.composable.zoo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jo.itsme.data.AnimalsDatas

@Composable
fun BodyZoo(paddingValues: PaddingValues) {
    LazyVerticalGrid(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier.padding(paddingValues),
        columns = GridCells.Fixed(2),
        content = {
            items(AnimalsDatas().allAnimals()) { animal ->
                AnimalView((animal))
            }
        })
}