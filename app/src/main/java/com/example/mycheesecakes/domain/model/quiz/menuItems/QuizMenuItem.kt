package com.example.mycheesecakes.domain.model.quiz.menuItems

import com.example.mycheesecakes.domain.model.menuitems.MenuItem
import com.example.mycheesecakes.domain.model.quiz.Question

abstract class QuizMenuItem(menuItem: MenuItem) {
    val name = menuItem.name
    val imageURL = menuItem.imageURL

    open lateinit var questionList: List<Question>

    open val propertyMap: HashMap<String,String> = hashMapOf()

    abstract fun createPropertyMap()
}