package com.example.mypizza.di

import dagger.Module
import dagger.Provides

@Module
class TestModule {

    @Provides
    fun provideSampleString(): String = "Hello world!"


}