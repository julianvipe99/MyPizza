package com.example.data.source.api.pizza.ingredients.entity

import com.example.domain.model.Ingrediente

data class IngredientesApiEntity (
    var id:Int,
    var nombre:String?,
    var price:Int
)

fun IngredientesApiEntity.mapToDomain()=
    Ingrediente(
        id,
        nombre?:"",
        price?:0
    )

fun List<IngredientesApiEntity>.mapToDomain()=this.map{it.mapToDomain()}