package com.example.mypizza.pizzafav.di

import com.example.data.repository.PizzaRepositoryImpl
import com.example.domain.usecase.GetAllFavPizzaUsesCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PizzaModule {
    @Singleton
    @Provides
    internal fun provideGetPizzaUseCase(
        pizzaRepositoryImpl: PizzaRepositoryImpl
    )=GetAllFavPizzaUsesCase(pizzaRepositoryImpl)
}