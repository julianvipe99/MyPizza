package com.example.data.source.api.pizza.ingredients.entity

import com.example.domain.model.Ingrediente

data class IngredientesApiEntity (
    var id:Int,
    var nombre:String?
)

fun IngredientesApiEntity.mapToDomain()=
    Ingrediente(
        id,
        nombre?:""
    )

fun List<IngredientesApiEntity>.mapToDomain()=this.map{it.mapToDomain()}