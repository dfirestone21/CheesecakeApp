package com.example.mycheesecakes.data.network.api.model

import com.google.gson.annotations.SerializedName

data class ApiDessert(
    @SerializedName("createdTime")
    val createdTime: String?,
    @SerializedName("fields")
    val fields: Fields?,
    @SerializedName("id")
    val id: String?
) {
    data class Fields(
        @SerializedName("base")
        val base: String?,
        @SerializedName("dishes")
        val dishes: String?,
        @SerializedName("fudge")
        val fudge: String?,
        @SerializedName("garnish")
        val garnish: String?,
        @SerializedName("ice_cream")
        val ice_cream: String?,
        @SerializedName("image_url")
        val imageUrl: String?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("whip_cream")
        val whippedCream: String?
    )
}
