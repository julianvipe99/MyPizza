package com.example.mypizza.pizzafav.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.model.Pizza
import com.example.domain.usecase.GetAllFavPizzaUsesCase
import com.example.mypizza.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import javax.inject.Inject

class PizzasViewModel
    @Inject constructor(
        getAllFavPizzaUsesCase: GetAllFavPizzaUsesCase
    ) : BaseViewModel(){

    private val pizzasLiveData = MutableLiveData<List<Pizza>>()
    private val pizzasErrorLiveData = MutableLiveData<Unit>()
        init {
            compositeDisposable.add(
                getAllFavPizzaUsesCase.execute()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object : DisposableSingleObserver<List<Pizza>>()  {
                        override fun onSuccess(t: List<Pizza>?) {
                            pizzasLiveData.value=t
                        }
                        override fun onError(e: Throwable?) {
                            pizzasErrorLiveData.value=Unit
                        }
                    })
            )
        }
    fun getPizzasLivedata(): LiveData<List<Pizza>> = pizzasLiveData

    }
