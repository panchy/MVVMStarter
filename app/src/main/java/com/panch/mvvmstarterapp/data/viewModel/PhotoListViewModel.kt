package com.panch.mvvmstarterapp.data.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.panch.mvvmstarterapp.base.BaseViewModel
import com.panch.mvvmstarterapp.data.rest.DataWrapper
import com.panch.mvvmstarterapp.data.rest.PhotoModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PhotoListViewModel : BaseViewModel() {

    private val _photos = MutableLiveData<DataWrapper<List<PhotoModel>>>()
    val photos: LiveData<DataWrapper<List<PhotoModel>>>
        get() = _photos

    init {
        _photos.value = DataWrapper()
    }

    fun loadPhotos() {
        val disposable = restClient.photosList
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it.isSuccessful) {
                    _photos.value = DataWrapper(it.body(), false)
                } else {
                    _photos.value = DataWrapper(loading = false)
                }
            }, {
                _photos.value = DataWrapper(loading = false)
            })
        compositeDisposable.add(disposable)
    }
}