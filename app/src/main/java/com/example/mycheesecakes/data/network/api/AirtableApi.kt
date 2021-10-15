package com.example.mycheesecakes.data.network.api

import com.example.mycheesecakes.data.network.api.model.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AirtableApi {
    @GET(ApiConstants.CHEESECAKES_ENDPOINT)
    suspend fun getAllCheesecakes(
        @Query(ApiParameters.API_KEY) apiKey: String = ApiConstants.API_KEY,
        @Query("sort%5B0%5D%5Bfield%5D=name\n" +
                "sort%5B0%5D%5Bdirection%5D=desc") sort: String = "sort%5B0%5D%5Bfield%5D=name\n" +
                "sort%5B0%5D%5Bdirection%5D=desc"
    ): Response<ApiCheesecakesList>

    @GET("${ApiConstants.CHEESECAKES_ENDPOINT}/{id}")
    suspend fun getCheesecake(
        @Query(ApiParameters.API_KEY) apiKey: String = ApiConstants.API_KEY,
        @Path("id") id: String
    ): Response<ApiCheesecake>

    @GET(ApiConstants.CHEESECAKES_ENDPOINT)
    suspend fun getCheesecakesByCategory(
        @Query(ApiParameters.API_KEY) apiKey: String = ApiConstants.API_KEY,
        @Query(ApiParameters.CHEESECAKE_CATEGORIES) categories: String
    ): Response<ApiCheesecakesList>

    @GET(ApiConstants.DESSERTS_ENDPOINT)
    suspend fun getAllDesserts(
        @Query(ApiParameters.API_KEY) apiKey: String = ApiConstants.API_KEY
    ): Response<ApiDessertList>

    @GET(ApiConstants.DRINKS_ENDPOINT)
    suspend fun getAllDrinks(
        @Query(ApiParameters.API_KEY) apiKey: String = ApiConstants.API_KEY
    ): Response<ApiDrinkList>

}
