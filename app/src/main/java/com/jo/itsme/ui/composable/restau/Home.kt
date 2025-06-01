package com.jo.itsme.ui.composable.restau

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jo.itsme.data.DataService
import com.jo.itsme.model.Screens

@Composable
fun Home() {
    val navigationController = rememberNavController()
    var menu by remember { mutableStateOf(DataService().americain) }
    val backStackEntry by navigationController.currentBackStackEntryAsState()
    val currentScreen = Screens.valueOf(backStackEntry?.destination?.route ?: Screens.Home.title)

    Scaffold(
        topBar = {
            AppBar(
                screens = currentScreen,
                goBack = { navigationController.navigateUp() },
                canGoBack = navigationController.previousBackStackEntry != null
            )
        },
        content = { paddingValues ->
            NavHost(
                navController = navigationController,
                startDestination = Screens.Home.name,
                modifier = Modifier.padding(paddingValues)
            ) {
                composable(route = Screens.Home.name) {
                    HomeScreen(onClick = { newMenu ->
                        println("Clicked")
                        menu = newMenu
                        navigationController.navigate(route = Screens.Entree.name)
                    })
                }
                composable(route = Screens.Entree.name) {
                    DetailView(article = menu.entree, btnTitle = "Vers les plats", onClick = {
                        navigationController.navigate(route = Screens.Plat.name)
                    })
                }
                composable(route = Screens.Plat.name) {
                    DetailView(article = menu.plat, btnTitle = "Vers les Desserts", onClick = {
                        navigationController.navigate(route = Screens.Dessert.name)
                    })
                }
                composable(route = Screens.Dessert.name) {
                    DetailView(article = menu.dessert, btnTitle = "Retour au menu", onClick = {
                        navigationController.popBackStack(Screens.Home.name, inclusive = false)
                    })
                }
            }
        }
    )
}
