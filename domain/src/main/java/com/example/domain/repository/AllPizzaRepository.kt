package com.example.domain.repository

import com.example.domain.model.AllPizza
import io.reactivex.rxjava3.core.Single

interface AllPizzaRepository {
    fun getAllPizzas(): Single<List<AllPizza>>
}