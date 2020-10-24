package com.example.data.source.api.pizza.all.entity

import com.example.domain.model.AllPizza

data class AllPizzaApiEntity (
    val id: Int,
    val nombre: String?,
    val url:String?,
    val description:String?
)

fun AllPizzaApiEntity.mapToDomain()=
    AllPizza(
        id,
        nombre?: "",
        url?: "",
        description?:""
    )
fun List<AllPizzaApiEntity>.mapToDomain()=this.map{it.mapToDomain()}