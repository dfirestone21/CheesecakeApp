package com.example.mycheesecakes.data.network.api.model

import com.google.gson.annotations.SerializedName

data class ApiDrinkList(
    @SerializedName("offset")
    val offset: String?,
    @SerializedName("records")
    val drinks: List<ApiDrink>?
)