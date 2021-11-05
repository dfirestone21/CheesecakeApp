package com.example.mycheesecakes.ui.flashcards

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycheesecakes.data.network.RetrofitInstance
import com.example.mycheesecakes.data.network.api.model.mappers.*
import com.example.mycheesecakes.domain.model.Category
import com.example.mycheesecakes.domain.model.Cheesecake
import com.example.mycheesecakes.domain.model.Nuts
import com.example.mycheesecakes.domain.model.menuitems.*
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import java.lang.IllegalArgumentException


class FlashcardsViewModel(var menuItemType: Int) : ViewModel() {
    val TAG = "FlashcardsViewModel"

    
    // The list of all menuItems of a given category
    private val _menuItemsLiveData = MutableLiveData<List<MenuItem>>()
    val menuItemsLiveData: LiveData<List<MenuItem>>
    get() = _menuItemsLiveData

    // The specific menuItem the user has chosen to view flashcard details of
    private val _menuItemLiveData = MutableLiveData<MenuItem>()
    val menuItemLiveData: LiveData<MenuItem>
    get() = _menuItemLiveData

    init {
        getMenuItems(menuItemType)
    }

    private fun getMenuItems(menuItemType: Int) {
        when (menuItemType) {
            MenuItem.TYPE_CHEESECAKE -> getCheesecakes()
            MenuItem.TYPE_DESSERT -> getDesserts()
            MenuItem.TYPE_DRINK -> getDrinks()
            else -> throw IllegalArgumentException("Invalid menuItem type")
        }
    }

    private fun getCheesecakes() {
        viewModelScope.launch {
            val response = try {
                RetrofitInstance.airtableApi.getAllCheesecakes()
            } catch (e: IOException) {
                Log.e(TAG, "IOException")
                return@launch
            } catch (e: HttpException) {
                Log.e(TAG, "HttpException")
                return@launch
            }

            if (response.isSuccessful && response.body() != null) {
                val apiCheesecakesList = response.body()
                val cheesecakeList = apiCheesecakesList?.cheesecakes?.let { cheesecakes ->
                    ListMapperImpl(ApiCheesecakeMapper()).mapToDomain(cheesecakes)
                }
                _menuItemsLiveData.value = cheesecakeList ?: return@launch
            }
        }
    }

    private fun getDesserts() {
        viewModelScope.launch() {
            val response = try {
                RetrofitInstance.airtableApi.getAllDesserts()
            } catch (e: IOException) {
                Log.e(TAG, "IOException")
                return@launch
            } catch (e: HttpException) {
                Log.e(TAG, "HttpException")
                return@launch
            }

            if (response.isSuccessful && response.body() != null) {
                val apiDessertList = response.body()
                val dessertList = apiDessertList?.desserts?.let { desserts ->
                    ListMapperImpl(ApiDessertMapper()).mapToDomain(desserts)
                }
                _menuItemsLiveData.value = dessertList ?: return@launch
            }
        }
    }

    private fun getDrinks() {
        viewModelScope.launch {
            val response = try {
                RetrofitInstance.airtableApi.getAllDrinks()
            } catch (e: IOException) {
                Log.e(TAG,"IOException")
                return@launch
            } catch (e: HttpException) {
                Log.e(TAG,"HttpException")
                return@launch
            }
            if (response.isSuccessful && response.body() != null) {
                val apiDrinkList = response.body()
                val dessertList = apiDrinkList?.drinks?.let { drinks ->
                    ListMapperImpl(ApiDrinkMapper()).mapToDomain(drinks)
                }
                _menuItemsLiveData.value = dessertList ?: return@launch
            }
        }
    }

    fun onMenuItemFlashcardSelected(menuItem: MenuItem) {
        Log.i(TAG,"onMenuItemFlashcardSelected called")
        _menuItemLiveData.value = menuItem
    }

    fun onMenuItemTypeChanged(menuItemType: Int) {
        this.menuItemType = menuItemType
        getMenuItems(menuItemType)
    }
}