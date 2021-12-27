package com.example.mycheesecakes.domain.model.quiz.menuItems

class QuizDessertMenuItem(
    override val name: String,
    override val imageURL: String,
    val dishes: String,
    val base: String,
    val iceCream: String,
    val fudge: String,
    val whippedCream: String,
): QuizMenuItem(name,imageURL) {

    /**
     * The map of questions to answers for this quiz item.
     */
    override val questionMap: HashMap<String, String> = hashMapOf()

    init {
        createPropertyMap()
    }

    override fun createPropertyMap() {
        questionMap.apply {
            put("Dishes",dishes)
            put("Base",base)
            put("Ice Cream",iceCream)
            put("Fudge",fudge)
            put("Whipped Cream",whippedCream)
        }
    }
}