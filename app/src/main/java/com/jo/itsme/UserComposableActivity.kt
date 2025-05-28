package com.jo.itsme

import android.os.Bundle
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jo.itsme.ui.theme.ItsMeTheme

class UserComposableActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            ItsMeTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Body()
                }
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun Body() {
        var name by remember { mutableStateOf("") }
        var surname by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var isKotlinCool by remember { mutableStateOf(true) }
        var sliderValue by remember { mutableFloatStateOf(0.5F) }

        var number by remember { mutableIntStateOf(0) }
        var compoteIndex by remember { mutableIntStateOf(0) }
        var compotes = listOf("Pomme", "Banane", "Poire", "Abricot", "Peche")

        val modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
        val manager = LocalFocusManager.current

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp, 0.dp)
        ) {
            NameTextField(name, onNameChanged = { name = it }, modifier, manager)
            SurnameTextField(surname, onSurnameChanged = { surname = it }, modifier, manager)
            SecureTextField(password, onChanged = { password = it }, modifier, manager)
            KotlinToggle(isKotlinCool, onCheckedChange = { isKotlinCool = it })
            SliderComposable(
                sliderValue,
                onChanged = { sliderValue = it },
                onFinished = { println("Fin du slider") })
            Text("Valeur du slider : $sliderValue")
            Radios(compoteIndex, compotes, modifier, onClick = { compoteIndex = it })
            Text("Compote sélectionnée : ${compotes[compoteIndex]}")
            Stepper(modifier, number = number, onTap = { number = it })
        }
    }

    @Composable
    fun NameTextField(
        name: String,
        onNameChanged: (String) -> Unit,
        modifier: Modifier,
        manager: FocusManager
    ) {
        TextField(
            value = name,
            onValueChange = onNameChanged,
            modifier = modifier,
            label = { Text("Entrez votre nom") },
            singleLine = true,
            //enabled = true,
            //readOnly = true,
            isError = name.isEmpty(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = { manager.moveFocus(FocusDirection.Down) }),
            placeholder = { Text("Nom inconnu") },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
            trailingIcon = {
                IconButton(onClick = { println("Click") }) {
                    Icon(Icons.AutoMirrored.Filled.Send, contentDescription = null)
                }
            })
    }

    @Composable
    fun SurnameTextField(
        surname: String,
        onSurnameChanged: (String) -> Unit,
        modifier: Modifier,
        manager: FocusManager
    ) {
        OutlinedTextField(
            value = surname,
            onValueChange = onSurnameChanged,
            modifier = modifier,
            label = { Text("Entrez votre prénom") },
            singleLine = true,
            keyboardActions = KeyboardActions(onNext = { manager.clearFocus() }),
            placeholder = { Text("Quel est votre prénom ?") },
        )
    }

    @Composable
    fun SecureTextField(
        password: String,
        onChanged: (String) -> Unit,
        modifier: Modifier,
        manager: FocusManager
    ) {
        var isSecure by remember { mutableStateOf(true) }
        OutlinedTextField(
            value = password,
            onValueChange = onChanged,
            modifier = modifier,
            singleLine = true,
            label = {
                Text("Mot de passe")
            },
            visualTransformation = if (isSecure) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { manager.moveFocus(FocusDirection.Down) }),
            trailingIcon = {
                IconButton(onClick = { isSecure = !isSecure }) {
                    Icon(
                        imageVector = if (isSecure) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        contentDescription = null
                    )
                }
            }
        )
    }

    @Composable
    fun KotlinToggle(checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
        Row() {
            Switch(
                checked = checked,
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
    fun SliderComposable(value: Float, onChanged: (Float) -> Unit, onFinished: () -> Unit) {
        Slider(
            value = value,
            onValueChange = onChanged,
            onValueChangeFinished = onFinished,
            valueRange = 0.0F..100.0F,
            steps = 10
        )
    }

    @Composable
    fun Radios(index: Int, compotes: List<String>, modifier: Modifier, onClick: (Int) -> Unit) {
        Row(modifier = modifier) {
            for (c in compotes.indices) {
                RadioButton(
                    selected = index == c,
                    onClick = { onClick(c) }
                )
            }
        }

    }

    @Composable
    fun Stepper(modifier: Modifier, number: Int, onTap: (Int) -> Unit) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Nombre : $number")
            Surface(
                modifier = Modifier
                    .height(45.dp)
                    .width(100.dp),
                border = BorderStroke(width = 1.dp, color = Color.Black),
                shape = RoundedCornerShape(15)
            ) {
                Row() {
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
