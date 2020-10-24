package com.example.data.di

import com.example.data.repository.AllPizzaRepositoryImpl
import com.example.data.source.api.pizza.all.client.AllPizzaApiClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DataSourceApiModule::class])
class DataAllPizzaModule {
    @Singleton
    @Provides
    internal fun providePizzaRepository(
        allPizzaApiClient: AllPizzaApiClient
    )= AllPizzaRepositoryImpl(allPizzaApiClient)
}