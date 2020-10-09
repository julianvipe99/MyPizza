package com.example.data.source.api.pizza.fav.client

import com.example.data.source.api.pizza.fav.entity.PizzaApiEntity
import retrofit2.Call
import retrofit2.http.GET

interface PizzaApiService {
    @GET("/pizzasFav")
    fun getPizzaFav(): Call<List<PizzaApiEntity>>
}