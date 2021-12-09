package com.example.mycheesecakes.domain.model.quiz.menuItems

import com.example.mycheesecakes.domain.model.Cheesecake
import com.example.mycheesecakes.domain.model.menuitems.Dessert
import com.example.mycheesecakes.domain.model.menuitems.Drink
import com.example.mycheesecakes.domain.model.menuitems.MenuItem
import com.example.mycheesecakes.domain.model.menuitems.util.toStringWithoutBrackets
import java.lang.IllegalArgumentException

class QuizMenuItemMapper {
    /**
     * Maps MenuItems to QuizMenuItems which are used for the Quiz
     */
    fun map(menuItem: MenuItem): QuizMenuItem {
        return when (menuItem) {
            is Cheesecake -> {
                QuizCheesecakeMenuItem(
                    name = menuItem.name,
                    imageURL = menuItem.imageURL,
                    cheesecake = menuItem.cheesecake,
                    crust = menuItem.crust,
                    nuts = menuItem.nuts.toString(),
                    dollops = menuItem.dollops,
                    topping = menuItem.topping,
                    presentation = menuItem.presentation
                )
            }
            is Dessert -> {
                QuizDessertMenuItem(
                    name = menuItem.name,
                    imageURL = menuItem.imageURL,
                    dishes = menuItem.dishes.toStringWithoutBrackets(),
                    base = menuItem.base,
                    iceCream = menuItem.iceCream,
                    fudge = menuItem.fudge,
                    whippedCream = menuItem.whippedCream
                )
            }
            is Drink -> {
                QuizDrinkMenuItem(
                    name = menuItem.name,
                    imageURL = menuItem.imageURL,
                    shots = menuItem.shots.toString(),
                    milk = menuItem.milk.toString(),
                    foam = menuItem.foam.toString(),
                    hasWhip = menuItem.hasWhip.toString(),
                    glassware = menuItem.glassware.toString(),
                    otherIngredients = menuItem.otherIngredients,
                    garnish = menuItem.garnish,
                    straw = menuItem.straw.toString()
                )
            }
            else -> throw IllegalArgumentException("Invalid MenuItem argument")
        }
    }
}