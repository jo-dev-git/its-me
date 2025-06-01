package com.jo.itsme.data

import androidx.annotation.DrawableRes

data class User(
    val name: String,
    @DrawableRes val imageName: Int)