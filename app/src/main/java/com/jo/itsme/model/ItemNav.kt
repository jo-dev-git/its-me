package com.jo.itsme.model

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.jo.itsme.R

//SEALED CLASS
sealed class ItemNav(
    val name: String,
    val icon: ImageVector,
    val route: String,
    @StringRes val title: Int,
    val color: Color,
) {
    data object Home : ItemNav("Accueil", Icons.Default.Home, "Home", R.string.accueil, Color.Blue)
    data object Mario : ItemNav("Mario", Icons.Default.Person, "Mario", R.string.mario, Color.Red)
    data object Princess :
        ItemNav("Princesse", Icons.Default.Star, "Princess", R.string.title_princess, Color.Magenta)

    data object Restau :
        ItemNav("Restau", Icons.Default.ShoppingCart, "Restau", R.string.title_top_bar, Color.Green)

    data object Strangers :
        ItemNav("Strangers", Icons.Default.Info, "Strangers", R.string.strangers_book, Color.Black)
}