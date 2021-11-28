package com.example.mycheesecakes.data.cache.model

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

fun listToJson(list: List<String>) = Gson().toJson(list)

fun jsonToList(json: String?): List<String> {
    val listType = object : TypeToken<List<String>>() {}.type
    return Gson().fromJson(json, listType)
}
