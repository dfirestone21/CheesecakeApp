package com.example.mycheesecakes.data.network.api.model

import com.google.gson.annotations.SerializedName

data class ApiQuizResult(
    @SerializedName("createdTime")
    val createdTime: String? = null,
    @SerializedName("fields")
    val fields: Fields?,
    @SerializedName("id")
    val id: String? = null
) {
    data class Fields(
        @SerializedName("correct")
        val correct: Int?,
        @SerializedName("date")
        val date: Long?,
        @SerializedName("id")
        val id: Int? = null,
        @SerializedName("incorrect")
        val incorrect: Int?
    )
}