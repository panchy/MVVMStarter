package com.panch.mvvmstarterapp.di.module



import com.panch.mvvmstarterapp.ui.main.detailFragment.DetailFragment
import com.panch.mvvmstarterapp.ui.main.detailFragment.DetailFragmentModule
import com.panch.mvvmstarterapp.ui.main.listFragment.ListFragment
import com.panch.mvvmstarterapp.ui.main.listFragment.ListFragmentModule
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentsBinder {

    @ContributesAndroidInjector(modules = [ListFragmentModule::class])
    abstract fun bindListFragment(): ListFragment

    @ContributesAndroidInjector(modules = [DetailFragmentModule::class])
    abstract fun bindDetailFragment(): DetailFragment


}