package com.example.mycheesecakes.data.network.api.model.mappers

/**
* Used to map API entities to objects in the domain in a low-coupling way.
 *
 * E: Entity
 * D: Domain
 **/
interface ApiMapper<E,D> {

    fun mapToDomain(apiEntity: E): D
}


interface ListMapper<E,D>: ApiMapper<List<E>,List<D>> {

}