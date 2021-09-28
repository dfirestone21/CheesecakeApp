package com.example.mycheesecakes.model.menuitems

import com.example.mycheesecakes.model.Category
import com.example.mycheesecakes.model.Cheesecake
import com.example.mycheesecakes.model.Nuts
import java.io.Serializable

const val MENU_ITEM_CHEESECAKE = 0
const val MENU_ITEM_DESSERT = 1
const val MENU_ITEM_DRINK = 2

abstract class MenuItem(
    open val name: String,
    open val imageURL: String
){

    abstract fun getProperties(): HashMap<String,String>

}


val menuItems: List<MenuItem> = listOf(
    Cheesecake("Lemon Raspberry Cream Cheesecake", "Lemon with seedless imported raspberries", "Ladyfingers/White cake", Nuts.NONE, "Two",
    "Lemon mousse", "One pasta spoon of raspberry puree",
    setOf(Category.FRUIT, Category.MOUSSE, Category.CAKE), "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_LemonRaspberryCreamCheesecake.jpg"),
    Dessert("Fresh Strawberry Shortcake","https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_StrawberryShortcake.jpg",setOf("Small Pasta Bowl"),
    "3 biscuits cut in half","3 scoops of 2 oz (6 oz), each scoop on a biscuit","None","Medium Dollop","6 fz. of sugared strawberries (3 small piles), 1 fz strawberry juice"),
    Drink("Cappuccino",2, Drink.Milk.SIX, Drink.Foam.LONG,false,Drink.Glassware.CAPPUCCINO,"None","Chocolate Powder",Drink.Straw.NONE,"https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_Cappuccino.jpg")
)