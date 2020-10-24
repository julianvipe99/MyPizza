package com.example.domain.usecase

import com.example.domain.model.AllPizza
import com.example.domain.repository.AllPizzaRepository
import io.reactivex.rxjava3.core.Scheduler

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class GetAllPizzaUsesCase(private val allPizzaRepository: AllPizzaRepository)
{
    fun execute():Single<List<AllPizza>> =
        allPizzaRepository.getAllPizzas()
            .subscribeOn(Schedulers.io())

}