package com.example.data.di

import com.example.data.repository.RecPizzaRepositoryImpl
import com.example.data.source.api.pizza.rec.client.PizzaRecApiClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DataSourceApiModule::class])
class DataRecPizzaModule {

    @Singleton
    @Provides
    internal fun provideRecPizzaRepository(
        pizzaRecApiClient: PizzaRecApiClient
    )= RecPizzaRepositoryImpl(pizzaRecApiClient)

}