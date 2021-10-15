package com.example.mycheesecakes.domain.model.menuitems

class Dessert(
        override val name: String,
        override val imageURL: String,
        val dishes: List<String>,
        val base: String,
        val iceCream: String,
        val fudge: String,
        val whippedCream: String,
        override val id: String? = null
) : MenuItem(id = id, name = name, imageURL = imageURL)