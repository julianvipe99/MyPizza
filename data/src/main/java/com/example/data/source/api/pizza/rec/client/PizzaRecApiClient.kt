package com.example.data.source.api.pizza.rec.client

import com.example.data.source.api.pizza.commons.SingleCallback
import com.example.data.source.api.pizza.fav.client.PizzaApiService
import com.example.data.source.api.pizza.fav.entity.PizzaApiEntity

import io.reactivex.rxjava3.core.Single

class PizzaRecApiClient(private val apiService: PizzaRecApiService){

    fun getPizzasRec(): Single<List<PizzaApiEntity>> =
        Single.create{
            val call = apiService.getPizzaRec()
            val callback = SingleCallback<List<PizzaApiEntity>>(it)

            call.enqueue(callback)
        }
}