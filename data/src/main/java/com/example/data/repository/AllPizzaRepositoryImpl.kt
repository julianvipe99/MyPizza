package com.example.data.repository

import com.example.data.source.api.pizza.all.client.AllPizzaApiClient
import com.example.data.source.api.pizza.all.entity.mapToDomain
import com.example.domain.model.AllPizza
import com.example.domain.repository.AllPizzaRepository
import io.reactivex.rxjava3.core.Single

class AllPizzaRepositoryImpl (
    private val AllpizzaApiClient: AllPizzaApiClient
): AllPizzaRepository {
    override fun getAllPizzas(): Single<List<AllPizza>> =
        AllpizzaApiClient.getPizzas()
            .map { it.mapToDomain() }
}