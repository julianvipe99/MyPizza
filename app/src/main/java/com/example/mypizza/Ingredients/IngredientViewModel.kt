package com.example.mypizza.Ingredients

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.model.Ingrediente
import com.example.domain.usecase.GetIngredientsUsesCase
import com.example.mypizza.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import java.lang.Error
import javax.inject.Inject

class IngredientViewModel
@Inject constructor(
    getIngredientsUsesCase: GetIngredientsUsesCase
): BaseViewModel() {

    private val ingredientLiveData = MutableLiveData<List<Ingrediente>>()
    private val ingredienteErrorLiveData = MutableLiveData<Unit>()

    init{
        compositeDisposable.addAll(
            getIngredientsUsesCase.execute()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Ingrediente>>(){
                    override fun onSuccess(t: List<Ingrediente>?) {
                        ingredientLiveData.value=t
                    }

                    override fun onError(e: Throwable?) {
                        ingredienteErrorLiveData.value = Unit
                    }
                })
        )
    }

    fun getIngredentsLiveData(): LiveData<List<Ingrediente>> = ingredientLiveData

}