package com.example.mycheesecakes.model.desserts

class ExtraDessert(
        name: String,
        imageURL: String,
        val dishes: Set<String>,
        val base: String,
        val iceCream: String,
        val fudge: String,
        val whippedCream: String,
        val toppings: String
) : Dessert(name, imageURL){

}