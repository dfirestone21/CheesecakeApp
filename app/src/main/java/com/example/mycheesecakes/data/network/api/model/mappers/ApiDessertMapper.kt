package com.example.mycheesecakes.data.network.api.model.mappers

import com.example.mycheesecakes.data.network.api.model.ApiDessert
import com.example.mycheesecakes.domain.model.menuitems.Dessert

class ApiDessertMapper : ApiMapper<ApiDessert, Dessert> {
    override fun mapToDomain(apiEntity: ApiDessert): Dessert {
        return Dessert(
            name = apiEntity.fields?.name.orEmpty(),
            imageURL = apiEntity.fields?.imageUrl.orEmpty(),
            dishes = parseDishes(apiEntity.fields?.dishes),
            base = apiEntity.fields?.base.orEmpty(),
            iceCream = apiEntity.fields?.ice_cream.orEmpty(),
            fudge = apiEntity.fields?.fudge.orEmpty(),
            whippedCream = apiEntity.fields?.whippedCream.orEmpty(),
            id = apiEntity.id
        )
    }

    private fun parseDishes(dishes: String?): List<String> {
        return if (dishes.isNullOrEmpty()) {
            emptyList()
        } else listOf(dishes)
    }
}