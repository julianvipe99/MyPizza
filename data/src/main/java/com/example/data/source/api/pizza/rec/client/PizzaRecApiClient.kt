package com.example.data.source.api.pizza.rec.client

import com.example.data.source.api.pizza.commons.SingleCallback
import com.example.data.source.api.pizza.rec.entity.PizzaRecApiEntity

import io.reactivex.rxjava3.core.Single

class PizzaRecApiClient(private val apiService: PizzaRecApiService){

    fun getPizzasRec(): Single<List<PizzaRecApiEntity>> =
        Single.create{
            val call = apiService.getPizzaRec()
            val callback = SingleCallback<List<PizzaRecApiEntity>>(it)

            call.enqueue(callback)
        }
}