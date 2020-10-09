package com.example.mypizza

import io.reactivex.rxjava3.disposables.CompositeDisposable
import androidx.lifecycle.ViewModel

open class BaseViewModel: ViewModel() {

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()

        super.onCleared()
    }
}