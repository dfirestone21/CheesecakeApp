package com.example.mycheesecakes.domain.model.quiz.menuItems

import com.example.mycheesecakes.domain.model.Cheesecake

class QuizCheesecakeMenuItem(private val cheesecake: Cheesecake): QuizMenuItem(cheesecake) {

    /**
     * The map of questions to answers for this quiz item.
     */
    override val propertyMap: HashMap<String, String> = hashMapOf()

    init {
        createPropertyMap()
    }

    override fun createPropertyMap() {
        propertyMap.apply {
            put("Cheesecake",cheesecake.cheesecake)
            put("Crust",cheesecake.crust)
            put("Nuts",cheesecake.nuts.toString())
            put("Dollops",cheesecake.dollops)
            put("Topping",cheesecake.topping)
            put("Presentation",cheesecake.presentation)
        }
    }
}
