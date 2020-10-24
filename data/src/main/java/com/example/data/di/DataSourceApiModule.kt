package com.example.data.di

import com.example.data.source.api.pizza.all.client.AllPizzaApiClient
import com.example.data.source.api.pizza.all.client.AllPizzaApiService
import com.example.data.source.api.pizza.fav.client.PizzaApiClient
import com.example.data.source.api.pizza.fav.client.PizzaApiService
import com.example.data.source.api.pizza.rec.client.PizzaRecApiClient
import com.example.data.source.api.pizza.rec.client.PizzaRecApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataSourceApiModule {
    @Singleton
    @Provides
    internal fun provideRetrofit() =
        Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/julianvipe99/pizzas/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    internal fun providePizzaApiClient(retrofit: Retrofit)=
        PizzaApiClient(retrofit.create(PizzaApiService::class.java))

    @Singleton
    @Provides
    internal  fun providePizzaRecApiClient(retrofit: Retrofit)=
        PizzaRecApiClient(retrofit.create(PizzaRecApiService::class.java))

    @Singleton
    @Provides
    internal  fun providePizzaAllApiClient(retrofit: Retrofit)=
        AllPizzaApiClient(retrofit.create(AllPizzaApiService::class.java))
}