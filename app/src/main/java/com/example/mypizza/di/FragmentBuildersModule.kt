package com.example.mypizza.di

import com.example.mypizza.ui.fragments.Login
import com.example.mypizza.ui.fragments.MainPage
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): MainPage

}