package com.example.domain.repository

import com.example.domain.model.Ingrediente
import io.reactivex.rxjava3.core.Single

interface IngredientRepository {
    fun getIngredients(): Single<List<Ingrediente>>
}