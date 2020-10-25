package com.example.data.repository

import com.example.data.source.api.pizza.ingredients.client.IngredientesApiClient
import com.example.data.source.api.pizza.ingredients.entity.mapToDomain
import com.example.domain.model.Ingrediente
import io.reactivex.rxjava3.core.Single
import com.example.domain.repository.IngredientRepository

class IngredientRepositoryImpl (
    private val ingredientesApiClient: IngredientesApiClient
): IngredientRepository{
    override fun getIngredients(): Single<List<Ingrediente>> =
    ingredientesApiClient.getIngredients()
        .map { it.mapToDomain() }
}