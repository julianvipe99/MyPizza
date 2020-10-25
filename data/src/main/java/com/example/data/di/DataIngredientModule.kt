package com.example.data.di

import com.example.data.repository.IngredientRepositoryImpl
import com.example.data.source.api.pizza.ingredients.client.IngredientesApiClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(includes = [DataSourceApiModule::class])
class DataIngredientModule {
    @Singleton
    @Provides
    internal fun provideIngredientRepository(
        ingredientesApiClient: IngredientesApiClient
    )= IngredientRepositoryImpl(ingredientesApiClient)

}