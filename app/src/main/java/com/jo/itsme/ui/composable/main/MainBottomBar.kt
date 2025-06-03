package com.jo.itsme.ui.composable.main

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.jo.itsme.data.BottomBarDatas
import com.jo.itsme.model.ItemNav

@Composable
fun MainBottomBar(navController: NavController, onChange: (title: Int) -> Unit) {
    fun onClick(itemNav: ItemNav) {
        navController.navigate(itemNav.route) {
            navController.graph.startDestinationRoute?.let { s ->
                popUpTo(s) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }
        onChange(itemNav.title)
    }
    BottomAppBar {
        //BackStackEntry
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        //CurrentRoute
        val currentRoute = navBackStackEntry?.destination?.route

        BottomBarDatas().items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = { onClick(item) },
                label = { Text(item.name) },
                icon = { Icon(item.icon, contentDescription = item.name) }
            )
        }
    }
}