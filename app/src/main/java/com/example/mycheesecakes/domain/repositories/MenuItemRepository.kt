package com.example.mycheesecakes.domain.repositories

import android.util.Log
import com.example.mycheesecakes.data.network.RetrofitInstance
import com.example.mycheesecakes.data.network.api.model.mappers.ApiCheesecakeMapper
import com.example.mycheesecakes.data.network.api.model.mappers.ListMapperImpl
import com.example.mycheesecakes.domain.model.Cheesecake
import com.example.mycheesecakes.domain.model.menuitems.Dessert
import com.example.mycheesecakes.domain.model.menuitems.Drink
import retrofit2.HttpException
import java.io.IOException

interface MenuItemRepository {

    suspend fun getAllCheesecakes(): List<Cheesecake>?

    suspend fun getAllDesserts(): List<Dessert>?

    suspend fun getAllDrinks(): List<Drink>?

    suspend fun getCheesecake(id: String): Cheesecake?

    suspend fun getDessert(id: String): Dessert?

    suspend fun getDrink(id: String): Drink?

    suspend fun getCheesecakesByCategory(category: String): List<Cheesecake>?
}