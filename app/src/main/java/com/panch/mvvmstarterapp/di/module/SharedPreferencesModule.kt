package com.panch.mvvmstarterapp.di.module

import android.content.Context
import android.content.SharedPreferences
import com.panch.mvvmstarterapp.App
import com.panch.mvvmstarterapp.data.sharedPref.UserDataProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SharedPreferencesModule {
    @Singleton
    @Provides
    fun provideSharedPreferences(app: App): SharedPreferences = app.getSharedPreferences("cached", Context.MODE_PRIVATE)

    @Singleton
    @Provides
    fun provideUserDataProvider(sharedPreferences: SharedPreferences): UserDataProvider = UserDataProvider(sharedPreferences)
}