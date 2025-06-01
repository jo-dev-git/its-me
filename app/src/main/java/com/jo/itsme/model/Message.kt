package com.jo.itsme.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Message(
    @StringRes val name: Int,
    @DrawableRes val image: Int,
    val msg: String
)
