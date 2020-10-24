package com.example.mypizza.pizzaall

import com.example.data.repository.AllPizzaRepositoryImpl
import com.example.domain.usecase.GetAllPizzaUsesCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PizzaAllModule {
    @Singleton
    @Provides
    internal fun provideGetAllPizzaUseCase(
        pizzaRepositoryImpl: AllPizzaRepositoryImpl
    )= GetAllPizzaUsesCase(pizzaRepositoryImpl)
}