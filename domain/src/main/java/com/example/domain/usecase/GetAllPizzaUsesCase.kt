package com.example.domain.usecase

import com.example.domain.model.Pizza
import com.example.domain.repository.PizzaRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers


class GetAllPizzaUsesCase(private val pizzaRepository: PizzaRepository) {

    fun execute(): Single<List<Pizza>> =
        pizzaRepository.getAllFavPizzas()
            .subscribeOn(Schedulers.io())

}