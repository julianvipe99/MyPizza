package com.example.data.source.api.pizza.rec.client


import com.example.data.source.api.pizza.rec.entity.PizzaRecApiEntity
import retrofit2.Call
import retrofit2.http.GET

interface PizzaRecApiService {
    @GET("pizzasRec")
    fun getPizzaRec(): Call<List<PizzaRecApiEntity>>
}