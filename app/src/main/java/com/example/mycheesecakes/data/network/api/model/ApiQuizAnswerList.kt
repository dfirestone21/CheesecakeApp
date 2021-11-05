package com.example.mycheesecakes.data.network.api.model

import android.icu.text.AlphabeticIndex
import com.google.gson.annotations.SerializedName

data class ApiQuizAnswerList(
    @SerializedName("records")
    val records: List<MenuItemResponse?>?
) {
    data class MenuItemResponse(
        @SerializedName("createdTime")
        val createdTime: String?,
        @SerializedName("fields")
        val answers: Answers?,
        @SerializedName("id")
        val id: String?
    ) {
        data class Answers(
            @SerializedName("categories")
            val categories: List<String>?,
            @SerializedName("cheesecake_type")
            val cheesecake_type: String?,
            @SerializedName("crust")
            val crust: String?,
            @SerializedName("dollops")
            val dollops: String?,
            @SerializedName("nuts")
            val nuts: String?,
            @SerializedName("presentation")
            val presentation: String?,
            @SerializedName("topping")
            val topping: String?,
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
            @SerializedName("whip_cream")
            val whip_cream: String?,
            @SerializedName("foam")
            val foam: String?,
            @SerializedName("milk")
            val milk: String?,
            @SerializedName("whip")
            val whip: String?,
            @SerializedName("shots")
            val shots: String?,
            @SerializedName("glassware")
            val glassware: String?,
            @SerializedName("other_ingredients")
            val other_ingredients: String?,
            @SerializedName("straws")
            val straws: String?,
        )
    }
}