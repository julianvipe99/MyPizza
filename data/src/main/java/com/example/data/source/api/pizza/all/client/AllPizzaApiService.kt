package com.example.data.source.api.pizza.all.client

import com.example.data.source.api.pizza.all.entity.AllPizzaApiEntity
import retrofit2.Call
import retrofit2.http.GET

interface AllPizzaApiService {
    @GET("Allpizzas")
    fun getAllPizza(): Call<List<AllPizzaApiEntity>>
}