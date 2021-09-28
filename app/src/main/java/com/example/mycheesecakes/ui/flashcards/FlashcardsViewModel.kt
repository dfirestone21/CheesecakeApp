package com.example.mycheesecakes.ui.flashcards

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mycheesecakes.domain.model.Category
import com.example.mycheesecakes.domain.model.Cheesecake
import com.example.mycheesecakes.domain.model.Nuts
import com.example.mycheesecakes.domain.model.menuitems.*
import java.lang.IllegalArgumentException


class FlashcardsViewModel(private val menuItemType: Int) : ViewModel() {
    val TAG = "FlashcardsViewModel"

    //TODO avoid instantiating dependencies like this, Use Dependency Injection in the constructor instead
    private val menuItemProvider = MenuItemProviderFactory.getProvider(menuItemType)

    // The list of all menuItems of a given category
    private val _menuItemsLiveData = MutableLiveData<List<MenuItem>>()
    val menuItemsLiveData: LiveData<List<MenuItem>>
    get() = _menuItemsLiveData

    // The specific menuItem the user has chosen to view flashcard details of
    private val _menuItemLiveData = MutableLiveData<MenuItem>()
    val menuItemLiveData: LiveData<MenuItem>
    get() = _menuItemLiveData

    init {
        Log.i("TAG","init called")
        _menuItemLiveData.value = Cheesecake(
            "30th Anniversary Chocolate Cake",
            "Original cheesecake",
            "Creamy chocolate fudge cake",
            Nuts.NONE                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       ,
            "One",
            "Chocolate cream, crunchy pearls of chocolate",
            "Whip",
            setOf(Category.CHOCOLATE, Category.CAKE),
            "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_30thChocolateAnnivCheesecake.jpg"
        )
        Log.i(TAG,"menuItemLiveData created: ${menuItemLiveData.value?.name}")
        getMenuItems()
    }

    private fun getMenuItems() {
        when (menuItemType) {
            MENU_ITEM_CHEESECAKE -> getCheesecakes()
            MENU_ITEM_DESSERT -> getDesserts()
            MENU_ITEM_DRINK -> getDrinks()
            else -> throw IllegalArgumentException("Invalid menuItem type")
        }
    }

    private fun getCheesecakes() {

    }

    private fun getDesserts() {

    }

    private fun getDrinks() {

    }

    fun onMenuItemFlashcardSelected(menuItem: MenuItem) {
        Log.i(TAG,"onMenuItemFlashcardSelected called")
        _menuItemLiveData.value = menuItem
    }
}