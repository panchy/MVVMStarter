package com.panch.mvvmstarterapp.di.module

import com.panch.mvvmstarterapp.ui.main.MainActivity
import com.panch.mvvmstarterapp.ui.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBinder {
    @ContributesAndroidInjector(modules = [MainActivityModule::class, MainActivityFragmentsBinder::class])
    abstract fun bindMainActivity(): MainActivity
}