package com.example.data.source.api.pizza.fav.entity

import com.example.domain.model.Pizza

data class PizzaApiEntity (
    val id: Int,
    val nombre: String?,
    val url:String?
)

fun PizzaApiEntity.mapToDomain()=
    Pizza(
        id,
        nombre?: "",
        url?: ""
)
fun List<PizzaApiEntity>.mapToDomain()=this.map{it.mapToDomain()}
