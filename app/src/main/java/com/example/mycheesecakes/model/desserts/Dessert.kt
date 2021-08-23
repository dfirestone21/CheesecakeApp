package com.example.mycheesecakes.model.desserts

class Dessert(
        name: String,
        imageURL: String,
        val dishes: Set<String>,
        val base: String,
        val iceCream: String,
        val fudge: String,
        val whippedCream: String,
        val toppings: String
) : MenuItem(name, imageURL){

}