package com.example.mycheesecakes.domain.repositories

import android.util.Log
import com.example.mycheesecakes.data.network.RetrofitInstance
import com.example.mycheesecakes.data.network.api.model.mappers.ApiCheesecakeMapper
import com.example.mycheesecakes.data.network.api.model.mappers.ListMapperImpl
import com.example.mycheesecakes.domain.model.Cheesecake
import retrofit2.HttpException
import java.io.IOException

interface MenuItemRepository {

    suspend fun getAllCheesecakes(): List<Cheesecake>? {
        val response = try {
            RetrofitInstance.airtableApi.getAllCheesecakes()
        } catch (e: IOException) {
            Log.e("MenuItemRepository", "IOException")
            return null
        } catch (e: HttpException) {
            Log.e("MenuItemRepository", "HttpException")
            return null
        }

        if (response.isSuccessful && response.body() != null) {
            val apiCheesecakes = response.body()
            val cheesecakes = apiCheesecakes?.cheesecakes?.let {
                ListMapperImpl(ApiCheesecakeMapper()).mapToDomain(
                    it
                )
            }
            return cheesecakes
        } else {
            return null
        }
    }


}