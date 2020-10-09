package com.example.data.repository

import com.example.data.source.api.pizza.fav.client.PizzaApiClient
import com.example.data.source.api.pizza.fav.entity.mapToDomain
import com.example.domain.model.Pizza
import com.example.domain.repository.PizzaRepository
import io.reactivex.rxjava3.core.Single

class PizzaRepositoryImpl(
    private val pizzaApiClient: PizzaApiClient
): PizzaRepository {
    override fun getAllFavPizzas(): Single<List<Pizza>> =
        pizzaApiClient.getPizzas()
            .map { it.mapToDomain() }
}