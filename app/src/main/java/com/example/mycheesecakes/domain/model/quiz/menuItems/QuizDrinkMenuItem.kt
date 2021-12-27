package com.example.mycheesecakes.domain.model.quiz.menuItems

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

    override val questionMap: HashMap<String, String> = hashMapOf()

    override fun createPropertyMap() {
        questionMap.apply {
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