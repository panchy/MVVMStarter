package com.panch.mvvmstarterapp.ui.main

import androidx.lifecycle.ViewModelProviders
import com.panch.mvvmstarterapp.data.viewModel.PhotoDetailViewModel
import com.panch.mvvmstarterapp.data.viewModel.PhotoListViewModel
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun providePhotoDetailViewModel(mainActivity: MainActivity): PhotoDetailViewModel =
        ViewModelProviders.of(mainActivity).get(PhotoDetailViewModel::class.java)


}