package com.example.data.di

import com.example.data.repository.PizzaRepositoryImpl
import com.example.data.source.api.pizza.fav.client.PizzaApiClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DataSourceApiModule::class])
class DataPizzaModule {

    @Singleton
    @Provides
    internal fun providePizzaRepository(
        pizzaApiClient: PizzaApiClient
    )= PizzaRepositoryImpl(pizzaApiClient)
}