package com.example.domain.usecase

import com.example.domain.model.Ingrediente
import com.example.domain.repository.IngredientRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class GetIngredientsUsesCase(private val ingredientRepository: IngredientRepository) {
    fun execute():Single<List<Ingrediente>> =
    ingredientRepository.getIngredients()
        .subscribeOn(Schedulers.io())
}