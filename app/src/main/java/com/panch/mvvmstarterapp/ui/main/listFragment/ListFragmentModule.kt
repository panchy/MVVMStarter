package com.panch.mvvmstarterapp.ui.main.listFragment

import androidx.lifecycle.ViewModelProviders
import com.panch.mvvmstarterapp.data.viewModel.PhotoListViewModel
import dagger.Module
import dagger.Provides

@Module
class ListFragmentModule {
    @Provides
    fun providePhotoListViewModel(fragment: ListFragment): PhotoListViewModel =
        ViewModelProviders.of(fragment).get(PhotoListViewModel::class.java)
}