package com.panch.mvvmstarterapp.base

import androidx.lifecycle.ViewModel
import com.panch.mvvmstarterapp.App
import com.panch.mvvmstarterapp.data.rest.RestApi
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {

    init {
        App.networkComponent.inject(this)
        Timber.e("Created ${javaClass.simpleName}")
    }

    @Inject
    lateinit var restClient: RestApi

    protected val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}