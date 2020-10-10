package com.example.mypizza.pizzarec

import com.example.data.repository.RecPizzaRepositoryImpl
import com.example.domain.usecase.GetAllRecPizzaUsesCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PizzaRecModule {
    @Singleton
    @Provides
    internal fun provideGetRecPizzaUseCase(
        pizzaRepositoryImpl: RecPizzaRepositoryImpl
    )= GetAllRecPizzaUsesCase(pizzaRepositoryImpl)
}