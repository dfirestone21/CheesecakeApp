package com.example.mycheesecakes.model.menuitems

import com.example.mycheesecakes.model.Cheesecake
import java.lang.IllegalArgumentException

abstract class MenuItemProvider

class CheesecakeProvider : MenuItemProvider() {
    /*

    fun getChocolateCheesecakes(): List<Cheesecake> {

    }

    fun getFruitCheesecakes(): List<Cheesecake> {

    }

    fun getCaramelCheesecakes(): List<Cheesecake> {

    }

    fun getCakeCheesecakes(): List<Cheesecake> {

    }

    fun getOtherCheesecakes(): List<Cheesecake> {

    }
    
     */

}

class DessertProvider : MenuItemProvider() {

}

class DrinkProvider : MenuItemProvider() {

}

abstract class MenuItemProviderFactory {
    val MENU_ITEM_CHEESECAKE = 0
    val MENU_ITEM_DESSERT = 1
    val MENU_ITEM_DRINK = 2

    companion object {
        fun getProvider(menuItemType: Int): MenuItemProvider {
            return when (menuItemType) {
                MENU_ITEM_CHEESECAKE -> CheesecakeProvider()
                MENU_ITEM_DESSERT -> DessertProvider()
                MENU_ITEM_DRINK -> DrinkProvider()
                else -> throw IllegalArgumentException("Invalid menuItemType: $menuItemType")
            }
        }
    }
}

/* Abstract all the business logic out of the viewmodel into here.

In this class you'll:
1. Receive the menuItemType as a parameter to determine which menuItems to provide.
    Possibly not necessary. Just have the viewmodel call a function here with requirements as parameter
2. Call the airtables API to retrieve which ones you want
3. Pass the appropriate menuItems back to the viewmodel
 */