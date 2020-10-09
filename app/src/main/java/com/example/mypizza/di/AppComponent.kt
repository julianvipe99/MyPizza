package com.example.mypizza.di

import android.app.Application
import com.example.data.di.DataPizzaModule
import com.example.data.di.DataSourceApiModule
import com.example.mypizza.TestApplication
import com.example.mypizza.pizza.di.PizzaModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        FragmentBuildersModule::class,
        TestModule::class,
        PizzaModule::class,
        DataPizzaModule::class,
        DataSourceApiModule::class
    ]
)


interface AppComponent : AndroidInjector<TestApplication> {
 @Component.Factory
 interface Factory{
     fun create(@BindsInstance application: Application):AppComponent
 }
}