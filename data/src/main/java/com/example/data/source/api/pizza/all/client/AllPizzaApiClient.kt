package com.example.data.source.api.pizza.all.client

import com.example.data.source.api.pizza.commons.SingleCallback
import com.example.data.source.api.pizza.all.entity.AllPizzaApiEntity
import io.reactivex.rxjava3.core.Single

class AllPizzaApiClient(private val apiService: AllPizzaApiService) {

    fun getPizzas(): Single<List<AllPizzaApiEntity>> =
        Single.create{
            val call = apiService.getAllPizza()
            val callback = SingleCallback<List<AllPizzaApiEntity>>(it)

            call.enqueue(callback)
        }
}