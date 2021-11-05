package com.example.mycheesecakes.data.cache.model

import com.google.gson.Gson

fun listToJson(list: List<String>) = Gson().toJson(list)

fun jsonToList(json: String): List<String> {
    val listType = TypeToken<List<String>> {}.getType
    return Gson().fromJson(json,listType)
}