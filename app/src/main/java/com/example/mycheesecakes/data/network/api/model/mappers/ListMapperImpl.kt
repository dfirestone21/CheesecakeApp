package com.example.mycheesecakes.data.network.api.model.mappers

class ListMapperImpl<E,D>(
    private val mapper: ApiMapper<E,D>
): ListMapper<E,D>{
    override fun mapToDomain(apiEntity: List<E>): List<D> {
        return apiEntity.map { mapper.mapToDomain(it) }
    }
}