package com.jo.itsme.data

import com.jo.itsme.R
import com.jo.itsme.model.Post
import com.jo.itsme.model.User

val lucas = User(name = "Lucas", imageName = R.drawable.lucas)
val eleven = User(name = "Eleven", imageName = R.drawable.eleven)
val eddie = User(name = "Eddie", imageName = R.drawable.eddie)


val bats = Post(
    user = eddie,
    imageId = R.drawable.bats,
    description = "Dis moi Dustin? Tu es toujours fan de Batman?",
    likes = 90,
    comments = 0,
    didLike = false
)
val crush = Post(
    user = lucas,
    imageId = R.drawable.crush,
    description = "Wouah ! J'ose pas trop l'aborder",
    likes = 88,
    comments = 4,
    didLike = true
)
val father = Post(
    user = eleven,
    imageId = R.drawable.father,
    description = "Bonne fête des pères à tous les PAPA",
    likes = 13,
    comments = 12,
    didLike = true
)
val fireworks = Post(
    user = eleven,
    imageId = R.drawable.fireworks,
    description = "Quand le vois Mike",
    likes = 64,
    comments = 34,
    didLike = false
)
val grass = Post(
    user = lucas,
    imageId = R.drawable.grass,
    description = "La mère de Dustin nous a dit: Regardez, dehors c'est de l'herbe, c'est pas toxique, vous pouvez sortir et jouer",
    likes = 83,
    comments = 4,
    didLike = false
)
val haircut = Post(
    user = eddie,
    imageId = R.drawable.haircut,
    description = "La derniere coupe à la mode.On a juste besoin de ciseaux et d'un bol",
    likes = 16,
    comments = 8,
    didLike = false
)
val marine = Post(
    user = lucas,
    imageId = R.drawable.marine,
    description = "C'est quand j'ai vu cet uniforme que je me suis décidé à m'inscrire au basket plutôt que trainer au centre commercial",
    likes = 45,
    comments = 56,
    didLike = false
)
val roller = Post(
    user = eleven,
    imageId = R.drawable.roller,
    description = "Love Love Love ❤️‍🔥",
    likes = 98,
    comments = 29,
    didLike = false
)
val snow = Post(
    user = eleven,
    imageId = R.drawable.snow,
    description = "La dernière fois que beau papa m'a dit: Viens on va à la neige, ca va être sympa !",
    likes = 323,
    comments = 1,
    didLike = false
)
val vecna = Post(
    user = eddie,
    imageId = R.drawable.vecna,
    description = "Il n'a pas mis de crème solaire ce gars la",
    likes = 456,
    comments = 79,
    didLike = false
)

fun allPosts(): List<Post> {
    return listOf(bats, crush, father, fireworks, grass, haircut, marine, roller, snow, vecna)
}