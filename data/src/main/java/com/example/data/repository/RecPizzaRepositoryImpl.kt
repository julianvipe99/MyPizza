package com.example.data.repository

import com.example.data.source.api.pizza.rec.entity.mapToDomain
import com.example.data.source.api.pizza.rec.client.PizzaRecApiClient
import com.example.domain.model.Pizza
import com.example.domain.repository.RecPizzaRepository
import io.reactivex.rxjava3.core.Single

class RecPizzaRepositoryImpl(
    private val pizzaRecApiClient: PizzaRecApiClient
): RecPizzaRepository {
    override fun getAllRecPizzas(): Single<List<Pizza>> =
        pizzaRecApiClient.getPizzasRec()
            .map { it.mapToDomain() }
}