package com.example.domain.usecase

import com.example.domain.model.Pizza
import com.example.domain.repository.RecPizzaRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class GetAllRecPizzaUsesCase(private val pizzaRepository: RecPizzaRepository){
    fun execute(): Single<List<Pizza>> =
        pizzaRepository.getAllRecPizzas()
            .subscribeOn(Schedulers.io())



}