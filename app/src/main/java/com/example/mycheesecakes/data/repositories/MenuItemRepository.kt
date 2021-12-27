package com.example.mycheesecakes.data.repositories

import android.util.Log
import com.example.mycheesecakes.data.network.api.AirtableApi
import com.example.mycheesecakes.data.network.api.model.mappers.ApiCheesecakeMapper
import com.example.mycheesecakes.data.network.api.model.mappers.ApiDessertMapper
import com.example.mycheesecakes.data.network.api.model.mappers.ApiDrinkMapper
import com.example.mycheesecakes.data.network.api.model.mappers.ListMapperImpl
import com.example.mycheesecakes.domain.model.Cheesecake
import com.example.mycheesecakes.domain.model.menuitems.Dessert
import com.example.mycheesecakes.domain.model.menuitems.Drink
import com.example.mycheesecakes.domain.repositories.MenuItemRepository
import retrofit2.HttpException
import java.io.IOException

const val TAG = "MenuItemRepository"

class MenuItemRepository(
    private val api: AirtableApi,
    private val cheesecakeMapper: ApiCheesecakeMapper,
    private val dessertMapper: ApiDessertMapper,
    private val drinkMapper: ApiDrinkMapper
    ) : MenuItemRepository {

    override suspend fun getAllCheesecakes(): List<Cheesecake>? {
        val response = try {
            api.getAllCheesecakes()
        } catch (e: IOException) {
            Log.e(TAG, "IOException")
            return null
        } catch (e: HttpException) {
            Log.e(TAG, "HttpException")
            return null
        }

        return if (response.isSuccessful && response.body() != null) {
            val apiCheesecakes = response.body()
            val cheesecakes = apiCheesecakes?.cheesecakes?.let { apiCakes ->
                apiCakes.map { cheesecakeMapper.mapToDomain(it) }
            }
            cheesecakes
        } else {
            null
        }
    }

    override suspend fun getAllDesserts(): List<Dessert>? {
        val response = try {
            api.getAllDesserts()
        } catch (e: IOException) {
            Log.e(TAG, "IOException")
            return null
        } catch (e: HttpException) {
            Log.e(TAG, "HttpException")
            return null
        }

        return if (response.isSuccessful && response.body() != null) {
            val apiDesserts = response.body()
            val desserts = apiDesserts?.desserts?.let { list ->
                list.map { dessertMapper.mapToDomain(it) }
            }
            desserts
        } else {
            null
        }
    }

    override suspend fun getAllDrinks(): List<Drink>? {
        val response = try {
            api.getAllDrinks()
        } catch (e: IOException) {
            Log.e(TAG, "IOException")
            return null
        } catch (e: HttpException) {
            Log.e(TAG, "HttpException")
            return null
        }
        return if (response.isSuccessful && response.body() != null) {
            val apiDrinkList = response.body()
            val drinkList = apiDrinkList?.drinks?.let {
                ListMapperImpl(drinkMapper).mapToDomain(it)
            }
            drinkList
        } else {
            null
        }
    }

    override suspend fun getCheesecake(id: String): Cheesecake? {
        val response = try {
            api.getCheesecake(id)
        } catch (e: IOException) {
            Log.e(TAG, "IOException")
            return null
        } catch (e: HttpException) {
            Log.e(TAG, "HttpException")
            return null
        }

        return if (response.isSuccessful && response.body() != null) {
            val apiCheesecake = response.body()
            val cheesecake = apiCheesecake?.let { cheesecakeMapper.mapToDomain(it) }
            cheesecake
        } else {
            null
        }
    }

    override suspend fun getDessert(id: String): Dessert? {
        val response = try {
            api.getDessert(id)
        } catch (e: IOException) {
            Log.e(TAG, "IOException")
            return null
        } catch (e: HttpException) {
            Log.e(TAG, "HttpException")
            return null
        }

        return if (response.isSuccessful && response.body() != null) {
            val apiDessert = response.body()
            val dessert = apiDessert?.let { dessertMapper.mapToDomain(it) }
            dessert
        } else {
            null
        }
    }

    override suspend fun getDrink(id: String): Drink? {
        val response = try {
            api.getDrink(id)
        } catch (e: IOException) {
            Log.e(TAG, "IOException")
            return null
        } catch (e: HttpException) {
            Log.e(TAG, "HttpException")
            return null
        }

        return if (response.isSuccessful && response.body() != null) {
            val apiDrink = response.body()
            val drink = apiDrink?.let { drinkMapper.mapToDomain(it) }
            drink
        } else {
            null
        }
    }

    override suspend fun getCheesecakesByCategory(category: String): List<Cheesecake>? {
        val response = try {
            api.getCheesecakesByCategory(category)
        } catch (e: IOException) {
            Log.e(TAG, "IOException")
            return null
        } catch (e: HttpException) {
            Log.e(TAG, "HttpException")
            return null
        }

        return if (response.isSuccessful && response.body() != null) {
            val apiCheesecakes = response.body()
            val cheesecakes = apiCheesecakes?.cheesecakes?.let {
                ListMapperImpl(cheesecakeMapper).mapToDomain(it)
            }
            cheesecakes
        } else {
            null
        }
    }
}