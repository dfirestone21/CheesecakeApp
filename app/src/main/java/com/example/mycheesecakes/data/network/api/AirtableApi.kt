package com.example.mycheesecakes.data.network.api

import com.example.mycheesecakes.data.network.api.model.*
import com.example.mycheesecakes.domain.model.quiz.Question
import com.example.mycheesecakes.domain.model.quiz.QuizResult
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface AirtableApi {
    @GET(ApiConstants.CHEESECAKES_ENDPOINT)
    suspend fun getAllCheesecakes(
        @Query(ApiParameters.API_KEY) apiKey: String = ApiConstants.API_KEY,
        @Query(ApiParameters.SORT_FIELD) field: String = ApiConstants.SORT_BY_ID,
        @Query(ApiParameters.SORT_DIRECTION) direction: String = ApiConstants.SORT_ASC
    ): Response<ApiCheesecakesList>

    @GET(ApiConstants.CHEESECAKES_ENDPOINT)
    suspend fun getCheesecakes(
        @Query(ApiParameters.API_KEY) apiKey: String = ApiConstants.API_KEY,
        @Query(ApiParameters.MAX_RECORDS) numRecords: Int
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

    @GET("{menuItemType}/{fields}")
    suspend fun getAnswers(
        @Path("menuItemType") menuItemType: String,
        @Path("fields") questions: List<String>,
        @Query(ApiParameters.API_KEY) apiKey: String = ApiConstants.API_KEY,
        @Query(ApiParameters.MAX_RECORDS) maxRecords: Int = 30
    ): Response<ApiQuizAnswerList>

    @POST(ApiConstants.QUIZ_RESULTS_ENDPOINT)
    suspend fun postQuizResult(
        @Body quizResult: ApiQuizResult,
        @Query(ApiParameters.API_KEY) apiKey: String = ApiConstants.API_KEY
    )


}
