package com.example.mycheesecakes.data.network.api.model

import com.google.gson.annotations.SerializedName

data class ApiDrink(
    @SerializedName("createdTime")
    val createdTime: String?,
    @SerializedName("fields")
    val fields: Fields?,
    @SerializedName("id")
    val id: String?
) {
    data class Fields(
        @SerializedName("foam")
        val foam: String?,
        @SerializedName("milk")
        val milk: String?,
        @SerializedName("whip")
        val whip: Boolean?,
        @SerializedName("shots")
        val shots: Int?,
        @SerializedName("garnish")
        val garnish: String?,
        @SerializedName("glassware")
        val glassware: String?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("other_ingredients")
        val otherIngredients: String?,
        @SerializedName("straws")
        val straws: String?,
        @SerializedName("image_url")
        val imageUrl: String?,
        @SerializedName("id")
        val id: String?
    )
}