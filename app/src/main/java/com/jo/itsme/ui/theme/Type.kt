package com.jo.itsme.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jo.itsme.R

val marioFont = FontFamily(
    Font(R.font.mario)
)

val philoFont = FontFamily(
    Font(R.font.philosopher_regular),
    Font(R.font.philosopher_bold, weight = FontWeight.Bold),
    Font(R.font.philosopher_italic, style = FontStyle.Italic),
    Font(R.font.philosopher_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic)
)

val customFont = FontFamily(
    Font(R.font.corpus_gaii_caps)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = philoFont,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        color = LightGrey
    ),
    titleLarge = TextStyle(
        fontFamily = marioFont,
        fontSize = 40.sp,
        color = LightGrey
    ),
    labelMedium = TextStyle(
        fontFamily = philoFont,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp,
        color = Red
    ),
    labelSmall = TextStyle(
        fontFamily = marioFont,
        fontSize = 22.sp,
        color = Blue
    ),
    displayMedium = TextStyle(
        fontFamily = customFont,
        fontSize = 30.sp
    )

)