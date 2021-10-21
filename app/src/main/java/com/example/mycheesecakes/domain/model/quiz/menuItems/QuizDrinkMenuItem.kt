package com.example.mycheesecakes.domain.model.quiz.menuItems

import com.example.mycheesecakes.domain.model.menuitems.Drink

class QuizDrinkMenuItem(
    override val name: String,
    override val imageURL: String,
    val shots: String,
    val milk: String,
    val foam: String,
    val hasWhip: String,
    val glassware: String,
    val otherIngredients: String,
    val garnish: String,
    val straw: String,
) : QuizMenuItem(name, imageURL) {

    override val propertyMap: HashMap<String, String> = hashMapOf()

    override fun createPropertyMap() {
        propertyMap.apply {
            put("Shots",shots)
            put("Milk",milk)
            put("Foam",foam)
            put("Whipped Cream",hasWhip)
            put("Glasses and Dishes",glassware)
            put("Other Ingredients",otherIngredients)
            put("Garnish",garnish)
            put("Straw",straw)
        }
    }
}