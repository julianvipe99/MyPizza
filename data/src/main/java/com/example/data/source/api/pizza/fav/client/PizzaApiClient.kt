package com.example.data.source.api.pizza.fav.client

import com.example.data.source.api.pizza.commons.SingleCallback
import com.example.data.source.api.pizza.fav.entity.PizzaApiEntity

import io.reactivex.rxjava3.core.Single

class PizzaApiClient(private val apiService:PizzaApiService) {

    fun getPizzas(): Single<List<PizzaApiEntity>> =
        Single.create{
            val call = apiService.getPizzaFav()
            val callback = SingleCallback<List<PizzaApiEntity>>(it)

            call.enqueue(callback)
        }
}