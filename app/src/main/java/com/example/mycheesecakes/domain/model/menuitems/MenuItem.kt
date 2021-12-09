package com.example.mycheesecakes.domain.model.menuitems

import com.example.mycheesecakes.domain.model.Category
import com.example.mycheesecakes.domain.model.Cheesecake
import com.example.mycheesecakes.domain.model.Nuts



abstract class MenuItem(
    open val id: String? = null,
    open val name: String,
    open val imageURL: String,
    //open val categories: List<Category> = listOf(), // Will be used for category feature.
    open var nutrition: Nutrition? = null
){

    companion object {
        const val TYPE_CHEESECAKE = 0
        const val TYPE_DESSERT = 1
        const val TYPE_DRINK = 2
    }

}


val menuItems: List<MenuItem> = listOf(
    Cheesecake("Lemon Raspberry Cream Cheesecake", "Lemon with seedless imported raspberries", "Ladyfingers/White cake", Nuts.NONE, "Two",
    "Lemon mousse", "One pasta spoon of raspberry puree",
    setOf(Category.FRUIT, Category.MOUSSE, Category.CAKE), "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_LemonRaspberryCreamCheesecake.jpg"),
    Dessert("Fresh Strawberry Shortcake","https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_StrawberryShortcake.jpg",listOf("Small Pasta Bowl"),
    "3 biscuits cut in half","3 scoops of 2 oz (6 oz), each scoop on a biscuit","None","Medium Dollop","6 fz. of sugared strawberries (3 small piles), 1 fz strawberry juice"),
    Drink("Cappuccino",2, Drink.Milk.SIX, Drink.Foam.LONG,false,Drink.Glassware.CAPPUCCINO,"None","Chocolate Powder",Drink.Straw.NONE,"https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_Cappuccino.jpg")
)
