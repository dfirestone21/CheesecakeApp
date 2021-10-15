package com.example.mycheesecakes.data.network.api.model

import com.example.mycheesecakes.domain.model.Category
import com.example.mycheesecakes.domain.model.Nuts
import com.google.gson.annotations.SerializedName

data class ApiCheesecake(
    @SerializedName("createdTime")
    val createdTime: String?,
    @SerializedName("fields")
    val fields: Fields?,
    @SerializedName("id")
    val id: String?
) {
    data class Fields(
        @SerializedName("categories")
        val categories: List<String>?,
        @SerializedName("cheesecake_type")
        val cheesecake: String?,
        @SerializedName("crust")
        val crust: String?,
        @SerializedName("dollops")
        val dollops: String?,
        @SerializedName("image_url")
        val imageURL: String?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("nuts")
        val nuts: String?,
        @SerializedName("presentation")
        val presentation: String?,
        @SerializedName("topping")
        val topping: String?,
        //@SerializedName("Nutrition")
        //val nutritionID: String?
    )
}