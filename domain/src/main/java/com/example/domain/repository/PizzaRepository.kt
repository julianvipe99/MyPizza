package com.example.domain.repository

import com.example.domain.model.Pizza
import io.reactivex.rxjava3.core.Single

interface PizzaRepository {

    fun getAllFavPizzas(): Single<List<Pizza>>


}