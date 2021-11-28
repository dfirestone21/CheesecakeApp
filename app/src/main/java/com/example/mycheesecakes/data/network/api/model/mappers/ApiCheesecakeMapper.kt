package com.example.mycheesecakes.data.network.api.model.mappers

import com.example.mycheesecakes.data.network.api.model.ApiCheesecake
import com.example.mycheesecakes.domain.model.Category
import com.example.mycheesecakes.domain.model.Cheesecake
import com.example.mycheesecakes.domain.model.Nuts
import java.util.*

class ApiCheesecakeMapper() : ApiMapper<ApiCheesecake,Cheesecake> {
    override fun mapToDomain(apiEntity: ApiCheesecake): Cheesecake {
        return Cheesecake(
            id = apiEntity.id,
            cheesecake = apiEntity.fields?.cheesecake.orEmpty(),
            crust = apiEntity.fields?.crust.orEmpty(),
            nuts = parseNuts(apiEntity.fields?.nuts),
            dollops = apiEntity.fields?.dollops.orEmpty(),
            topping = apiEntity.fields?.topping.orEmpty(),
            presentation = apiEntity.fields?.presentation.orEmpty(),
            categories = parseCategories(apiEntity.fields?.categories).toSet(),
            name = apiEntity.fields?.name.orEmpty(),
            imageURL = apiEntity.fields?.imageURL.orEmpty()
        )
    }

    private fun parseNuts(nuts: String?): Nuts {
        if (nuts.isNullOrEmpty()) return Nuts.NONE
        return Nuts.valueOf(nuts.toUpperCase(Locale.ROOT))
    }

    private fun parseCategories(categories: List<String>?): List<Category> {
        if (categories.isNullOrEmpty()) return emptyList()

        val mappedCategories: MutableList<Category> = mutableListOf()
        for (item in categories) {
            mappedCategories.add(Category.valueOf(item.toUpperCase(Locale.ROOT)))
        }
        return mappedCategories
    }
}