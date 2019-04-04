package com.panch.mvvmstarterapp.data.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.panch.mvvmstarterapp.base.BaseViewModel
import com.panch.mvvmstarterapp.data.rest.PhotoModel

class PhotoDetailViewModel : BaseViewModel() {
    private val _selectedPhoto = MutableLiveData<PhotoModel>()
    val selectedPhoto: LiveData<PhotoModel>
        get() = _selectedPhoto

    fun setSelectedPhoto(photoModel: PhotoModel) {
        _selectedPhoto.value = photoModel
    }
}