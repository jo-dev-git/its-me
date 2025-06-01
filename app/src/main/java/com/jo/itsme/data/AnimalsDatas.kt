package com.jo.itsme.data

import com.jo.itsme.R
import com.jo.itsme.model.Animal

class AnimalsDatas() {

    val maki = Animal(name = "Maki Catta", image = R.drawable.maki)
    val capu = Animal(name = "Capucin brun", image = R.drawable.capu)
    val fennec = Animal(name = "Fennec", image = R.drawable.fennec)
    val ocelot = Animal(name = "Ocelot", image = R.drawable.ocelot)
    val serval = Animal(name = "Serval", image = R.drawable.serval)
    val elephant = Animal(name = "Éléphant", image = R.drawable.elephant)
    val tigre = Animal(name = "Tigre", image = R.drawable.tigre)
    val loutre = Animal(name = "Loutre d'Europe", image = R.drawable.loutre)
    val ali = Animal(name = "Alligator", image = R.drawable.alligator)
    val naja = Animal(name = "Naja", image = R.drawable.naja)
    val iguane = Animal(name = "Iguane vert", image = R.drawable.iguane)
    val tortue = Animal(name = "Tortue d'Hermann", image = R.drawable.tortue)
    val aigle = Animal(name = "Pygargue à tête blanche", image = R.drawable.eagle)
    val ara = Animal(name = "Ara bleu", image = R.drawable.ara)
    val cagou = Animal(name = "Cagou", image = R.drawable.cagou)
    val kiwi = Animal(name = "Kiwi Austral", image = R.drawable.kiwi)

    fun allAnimals(): List<Animal> {
        return listOf(
            maki,
            capu,
            fennec,
            ocelot,
            serval,
            elephant,
            tigre,
            loutre,
            ali,
            naja,
            iguane,
            tortue,
            aigle,
            ara,
            cagou,
            kiwi
        )
    }
}