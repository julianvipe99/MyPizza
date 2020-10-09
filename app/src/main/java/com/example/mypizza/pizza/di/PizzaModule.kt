package com.example.mypizza.pizza.di

import com.example.data.repository.PizzaRepositoryImpl
import com.example.domain.usecase.GetAllPizzaUsesCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PizzaModule {
    @Singleton
    @Provides
    internal fun provideGetPizzaUseCase(
        pizzaRepositoryImpl: PizzaRepositoryImpl
    )=GetAllPizzaUsesCase(pizzaRepositoryImpl)
}