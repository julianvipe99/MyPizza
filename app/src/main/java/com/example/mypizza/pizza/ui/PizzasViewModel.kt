package com.example.mypizza.pizza.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.model.Pizza
import com.example.domain.usecase.GetAllPizzaUsesCase
import com.example.mypizza.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import javax.inject.Inject

class PizzasViewModel
    @Inject constructor(
        getAllPizzaUsesCase: GetAllPizzaUsesCase
    ) : BaseViewModel(){

    private val pizzasLiveData = MutableLiveData<List<Pizza>>()
    private val pizzasErrorLiveData = MutableLiveData<Unit>()
        init {
            compositeDisposable.add(
                getAllPizzaUsesCase.execute()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object : DisposableSingleObserver<List<Pizza>>()  {
                        override fun onSuccess(t: List<Pizza>?) {
                            Log.e("List from service", t.toString())
                        }
                        override fun onError(e: Throwable?) {
                            Log.e("ERROR", e.toString())
                        }
                    })
            )
        }
    fun getPizzasLivedata(): LiveData<List<Pizza>> = pizzasLiveData

    }
