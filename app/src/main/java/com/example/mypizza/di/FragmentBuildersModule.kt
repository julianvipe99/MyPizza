package com.example.mypizza.di


import com.example.mypizza.ui.fragments.CrearPizza
import com.example.mypizza.ui.fragments.MainPage
import com.example.mypizza.ui.fragments.Search
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): MainPage
    @ContributesAndroidInjector
    abstract fun contributeSearchFragment(): Search
    @ContributesAndroidInjector
    abstract fun contributeCrearPFragment(): CrearPizza

}