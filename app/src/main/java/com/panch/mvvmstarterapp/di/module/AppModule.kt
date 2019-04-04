package com.panch.mvvmstarterapp.di.module

import android.app.Application
import com.panch.mvvmstarterapp.App
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    fun provideApp(application: Application): App {
        return application as App
    }
}