package com.example.data.source.api.pizza.ingredients.client

import retrofit2.http.GET
import retrofit2.Call
import com.example.data.source.api.pizza.ingredients.entity.IngredientesApiEntity

interface IngredientesApiService {

    @GET("Ingredientes")
    fun getIngredient(): Call<List<IngredientesApiEntity>>

}