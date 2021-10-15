package com.example.mycheesecakes.data.network.api.model

import android.icu.text.AlphabeticIndex
import com.google.gson.annotations.SerializedName

data class ApiDessertList(
    @SerializedName("offset")
    val offset: String?,
    @SerializedName("records")
    val desserts: List<ApiDessert>?
)