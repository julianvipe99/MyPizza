package com.example.data.source.api.pizza.all.entity

import com.example.domain.model.AllPizza

data class AllPizzaApiEntity (
    val id: Int,
    val nombre: String?,
    val url:String?,
    val description:String?,
    val small: Int?,
    val medium: Int?,
    val large: Int?
)

fun AllPizzaApiEntity.mapToDomain()=
    AllPizza(
        id,
        nombre?: "",
        url?: "",
        description?:"",
        small?:0,
        medium?:0,
        large?:0
    )
fun List<AllPizzaApiEntity>.mapToDomain()=this.map{it.mapToDomain()}