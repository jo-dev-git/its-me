package com.jo.itsme

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jo.itsme.ui.theme.ItsMeTheme

class ImcActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ItsMeTheme {
                ScaffoldComposable()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ScaffoldComposable() {
        Scaffold(
            topBar = { Top() },
            content = { it: PaddingValues -> Body(it) }
        )
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Preview(showBackground = true)
    @Composable
    fun Top() {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.title_imc),
                    fontSize = 22.sp,
                    color = Color.White
                )
            },
        )
    }

    @Composable
    fun Body(paddingValues: PaddingValues) {


        var name by remember { mutableStateOf("") }
        var age by remember { mutableStateOf("") }

        var isAMan by remember { mutableStateOf(true) }
        var height by remember { mutableFloatStateOf(120F) }

        var weight by remember { mutableIntStateOf(0) }
        var levelIndex by remember { mutableIntStateOf(0) }
        val levelsActivity = listOf("Sédentaire", "Faible", "Actif", "Sportif", "Athlete")
        var calories by remember { mutableIntStateOf(0) }

        val modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 0.dp)
        val manager = LocalFocusManager.current

        fun getCoeff() : Double {
            return when(levelIndex) {
                0 -> 1.2
                1 -> 1.375
                2 -> 1.55
                3 -> 1.72
                else -> 1.9
            }
        }

        fun calculate() : Int {
            var result = ""
            if (name != "") result += name
            var ageInt = age.toIntOrNull() ?: 20
            val caloriesBase = (10 * weight) + (6.25 * height.toInt()) - (5 * ageInt)
            val caloriesGender = if (isAMan) caloriesBase + 5 else caloriesBase - 161
            val caloriesActivity = caloriesGender * getCoeff()
            return  caloriesActivity.toInt()
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = spacedBy(8.dp)
        ) {
            NameTextField(name, onNameChanged = { name = it }, modifier, manager)
            AgeTextField(age, onChanged = { age = it }, modifier, manager)
            GenderToggle(isAMan, onCheckedChange = { isAMan = it }, modifier)
            WeightComposable(modifier, number = weight, onTap = { weight = it })
            Text("Taille : ${height.toInt()}cm")
            SliderComposable(
                height,
                onChanged = { height = it })
            Radios(levelIndex, levelsActivity, modifier, onClick = { levelIndex = it })
            Button(
                modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp),
                onClick = {calories = calculate()}) {
                Text(stringResource(R.string.calculate))
            }
            Text(modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp),
                text = "$name, vous avez besoin de $calories calories journalières")
        }
    }

    @Composable
    fun NameTextField(
        name: String,
        onNameChanged: (String) -> Unit,
        modifier: Modifier,
        manager: FocusManager
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = onNameChanged,
            modifier = modifier,
            label = { Text(stringResource(R.string.name)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = { manager.moveFocus(FocusDirection.Down) }),
        )
    }

    @Composable
    fun AgeTextField(
        age: String,
        onChanged: (String) -> Unit,
        modifier: Modifier,
        manager: FocusManager
    ) {
        OutlinedTextField(
            value = age,
            onValueChange = onChanged,
            modifier = modifier,
            label = { Text(stringResource(R.string.age)) },
            singleLine = true,
            keyboardActions = KeyboardActions(onNext = { manager.clearFocus() }),
        )
    }

    @Composable
    fun GenderToggle(isAMan: Boolean, onCheckedChange: (Boolean) -> Unit, modifier: Modifier) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(if (isAMan) "Homme" else "Femme")
            Switch(
                checked = isAMan,
                onCheckedChange = onCheckedChange,
                colors = SwitchDefaults.colors(
                    checkedTrackColor = Color.Blue,
                    checkedIconColor = Color.Blue,
                    uncheckedThumbColor = Color.Green
                )
            )
        }
    }

    @Composable
    fun SliderComposable(value: Float, onChanged: (Float) -> Unit) {
        Slider(
            value = value,
            onValueChange = onChanged,
            valueRange = 120.0F..220.0F,
        )
    }

    @Composable
    fun Radios(index: Int, levels: List<String>, modifier: Modifier, onClick: (Int) -> Unit) {
        Row(modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            for (c in levels.indices) {
                Column {
                    RadioButton(
                        selected = index == c,
                        onClick = { onClick(c) }
                    )
                    Text(levels[c])
                }
            }
        }
    }

    @Composable
    fun WeightComposable(modifier: Modifier, number: Int, onTap: (Int) -> Unit) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Kilos : $number")
            Surface(
                modifier = Modifier
                    .height(45.dp)
                    .width(100.dp),
                border = BorderStroke(width = 1.dp, color = Color.Black),
                shape = RoundedCornerShape(15)
            ) {
                Row {
                    IconButton(onClick = { onTap(number + 1) }) {
                        Text("+")
                    }
                    IconButton(onClick = { onTap(number - 1) }) {
                        Text("-")
                    }
                }
            }
        }
    }
}
