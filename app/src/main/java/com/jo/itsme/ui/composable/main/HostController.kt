package com.jo.itsme.ui.composable.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jo.itsme.ui.composable.screen.StrangersScreen
import com.jo.itsme.data.BottomBarDatas
import com.jo.itsme.model.ItemNav
import com.jo.itsme.ui.composable.screen.MarioScreen
import com.jo.itsme.ui.composable.screen.PrincessScreen
import com.jo.itsme.ui.composable.screen.RestauScreen

@Composable
fun HostController(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = ItemNav.Home.route
    ) {
        BottomBarDatas().items.forEach { item ->
            when (item.route) {
                ItemNav.Home.route -> composable(ItemNav.Home.route) {
                    MarioScreen()
                }

                ItemNav.Mario.route -> composable(ItemNav.Mario.route) {
                    MarioScreen()
                }

                ItemNav.Princess.route -> composable(ItemNav.Princess.route) {
                    PrincessScreen()
                }

                ItemNav.Restau.route -> composable(ItemNav.Restau.route) {
                    RestauScreen()
                }

                ItemNav.Strangers.route -> composable(ItemNav.Strangers.route) {
                    StrangersScreen()
                }

                else -> Unit
            }
        }
    }
}