package com.example.data.source.api.pizza.ingredients.client

import com.example.data.source.api.pizza.commons.SingleCallback
import com.example.data.source.api.pizza.ingredients.entity.IngredientesApiEntity
import io.reactivex.rxjava3.core.Single

class IngredientesApiClient(private val apiService: IngredientesApiService) {

    fun getIngredients():Single<List<IngredientesApiEntity>> =
        Single.create{
            val call = apiService.getIngredient()
            val callback = SingleCallback<List<IngredientesApiEntity>>(it)

            call.enqueue(callback)
        }
}