package com.example.mycheesecakes.data.network

import com.example.mycheesecakes.data.network.api.AirtableApi
import com.example.mycheesecakes.data.network.api.ApiConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val airtableApi: AirtableApi by lazy {
        Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AirtableApi::class.java)
    }
}