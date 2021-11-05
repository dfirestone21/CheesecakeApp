package com.example.mycheesecakes.data.network.api

abstract class ApiParameters {
    companion object {
        const val MAX_RECORDS = "maxRecords"
        const val API_KEY = "api_key"
        const val CHEESECAKE_ID = ""
        const val SORT_FIELD = "field"
        const val SORT_DIRECTION = "direction"
        const val CHEESECAKE_CATEGORIES = "categories"
    }
}

//sort%5B0%5D%5Bfield%5D
//sort%5B0%5D%5Bdirection%5D