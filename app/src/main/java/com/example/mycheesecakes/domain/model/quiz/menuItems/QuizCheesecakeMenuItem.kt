package com.example.mycheesecakes.domain.model.quiz.menuItems

class QuizCheesecakeMenuItem(
    override val name: String,
    override val imageURL: String,
    val cheesecake: String,
    val crust: String,
    val nuts: String,
    val dollops: String,
    val topping: String,
    val presentation: String
): QuizMenuItem(name, imageURL) {

    /**
     * The map of questions to answers for this quiz item.
     */
    override val questionMap: HashMap<String, String> = hashMapOf()

    init {
        createPropertyMap()
    }

    override fun createPropertyMap() {
        questionMap.apply {
            put("Cheesecake",cheesecake)
            put("Crust",crust)
            put("Nuts",nuts)
            put("Dollops",dollops)
            put("Topping",topping)
            put("Presentation",presentation)
        }
    }
}
