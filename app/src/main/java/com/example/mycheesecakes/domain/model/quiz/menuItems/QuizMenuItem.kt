package com.example.mycheesecakes.domain.model.quiz.menuItems

import com.example.mycheesecakes.domain.model.menuitems.MenuItem
import com.example.mycheesecakes.domain.model.quiz.Question

abstract class QuizMenuItem(
    open val name: String,
    open val imageURL: String,
) {

    /**
     * The map of questions to answers for this quiz item.
     */
    abstract val propertyMap: HashMap<String,String>

    abstract fun createPropertyMap()
}