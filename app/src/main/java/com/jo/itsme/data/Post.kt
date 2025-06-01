package com.jo.itsme.data

import androidx.annotation.DrawableRes

data class Post(
    val user: User,
    @DrawableRes val imageId: Int,
    val description: String,
    val likes: Int,
    val comments: Int,
    val didLike: Boolean
)
