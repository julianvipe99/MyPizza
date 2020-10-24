package com.example.mypizza.pizzaall

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.model.AllPizza
import com.example.domain.usecase.GetAllPizzaUsesCase
import com.example.mypizza.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import javax.inject.Inject

class AllPizzasViewModel
    @Inject constructor(
    getAllPizzaUsesCase: GetAllPizzaUsesCase
) : BaseViewModel() {

    private val pizzasLiveData = MutableLiveData<List<AllPizza>>()
    private val pizzasErrorLiveData = MutableLiveData<Unit>()

    init {
        compositeDisposable.add(
            getAllPizzaUsesCase.execute()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<AllPizza>>() {
                    override fun onSuccess(t: List<AllPizza>?) {
                        pizzasLiveData.value = t
                    }

                    override fun onError(e: Throwable?) {
                        pizzasErrorLiveData.value = Unit
                    }
                })
        )
    }

    fun getAllPizzasLivedata(): LiveData<List<AllPizza>> = pizzasLiveData
}