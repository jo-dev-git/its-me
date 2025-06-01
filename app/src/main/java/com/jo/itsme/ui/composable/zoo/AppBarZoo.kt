package com.jo.itsme.ui.composable.zoo

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jo.itsme.R
import com.jo.itsme.ui.theme.ItsMeTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun AppBarZoo() {
    TopAppBar(
        title = {Text(stringResource(R.string.my_zoo), style = MaterialTheme.typography.displayMedium) },
        navigationIcon = { Image(
            painterResource(R.drawable.iconapp),
            contentDescription = null,
            modifier =  Modifier.padding(5.dp))
        })
}

@Preview(showBackground = true)
@Composable
fun AppBarZooPreview() {
    ItsMeTheme {
        AppBarZoo()
    }
}