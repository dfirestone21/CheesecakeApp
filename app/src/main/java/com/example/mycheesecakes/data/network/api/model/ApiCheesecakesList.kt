package com.example.mycheesecakes.data.network.api.model

import com.google.gson.annotations.SerializedName

data class ApiCheesecakesList(
    @SerializedName("offset")
    val offset: String?,
    @SerializedName("records")
    val cheesecakes: List<ApiCheesecake>?
)