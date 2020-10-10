package com.example.mypizza.di

import android.app.Application
import com.example.data.di.DataPizzaModule
import com.example.data.di.DataRecPizzaModule
import com.example.data.di.DataSourceApiModule
import com.example.mypizza.TestApplication
import com.example.mypizza.pizzafav.di.PizzaModule
import com.example.mypizza.pizzarec.PizzaRecModule
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
        PizzaRecModule::class,
        DataRecPizzaModule::class,
        DataSourceApiModule::class
    ]
)


interface AppComponent : AndroidInjector<TestApplication> {
 @Component.Factory
 interface Factory{
     fun create(@BindsInstance application: Application):AppComponent
 }
}