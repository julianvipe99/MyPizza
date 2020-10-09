package com.example.data.source.api.pizza.fav.entity

import com.example.domain.model.Pizza

data class PizzaApiEntity (
    val id: Int,
    val name: String?,
    val url:String?
)

fun PizzaApiEntity.mapToDomain()=
    Pizza(
        id,
        name?: "",
        url?: ""
)
fun List<PizzaApiEntity>.mapToDomain()=this.map{it.mapToDomain()}
