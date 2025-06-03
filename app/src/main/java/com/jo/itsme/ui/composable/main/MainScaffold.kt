package com.jo.itsme.ui.composable.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import com.jo.itsme.R
import com.jo.itsme.ui.composable.AppBarComposable

@Composable
fun MainScaffold() {
    val navController = rememberNavController()
    var title by remember { mutableIntStateOf(R.string.accueil) }

    fun OnChange(titleScreen: Int) {
        title = titleScreen
    }

    Scaffold(
        topBar = { AppBarComposable(stringResource(title)) },
        bottomBar = { MainBottomBar(navController, onChange = { OnChange(it) }) })
    { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            HostController(navController)
        }
    }
}


