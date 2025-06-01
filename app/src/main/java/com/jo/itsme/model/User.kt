package com.jo.itsme.model

import androidx.annotation.DrawableRes

data class User(
    val name: String,
    @DrawableRes val imageName: Int
)