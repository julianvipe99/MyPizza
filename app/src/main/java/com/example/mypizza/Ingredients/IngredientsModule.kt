package com.example.mypizza.Ingredients

import com.example.data.repository.IngredientRepositoryImpl
import com.example.domain.usecase.GetIngredientsUsesCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class IngredientsModule {
    @Singleton
    @Provides
    internal fun provideGetIngredientUseCase(
        ingredientRepositoryImpl: IngredientRepositoryImpl
    ) = GetIngredientsUsesCase(ingredientRepositoryImpl)
}