package com.example.data.source.api.pizza.rec.entity

import com.example.domain.model.Pizza

data class PizzaRecApiEntity (
    val id: Int,
    val nombre: String?,
    val url:String?
)

fun PizzaRecApiEntity.mapToDomain()=
    Pizza(
        id,
        nombre?: "",
        url?: ""
    )
fun List<PizzaRecApiEntity>.mapToDomain()=this.map{it.mapToDomain()}
