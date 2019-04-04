package com.panch.mvvmstarterapp.di.component

import android.app.Application
import com.panch.mvvmstarterapp.base.BaseViewModel
import com.panch.mvvmstarterapp.di.module.ActivityBinder
import com.panch.mvvmstarterapp.di.module.AppModule
import com.panch.mvvmstarterapp.di.module.NetworkModule
import com.panch.mvvmstarterapp.di.module.SharedPreferencesModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        ActivityBinder::class,
        AppModule::class,
        SharedPreferencesModule::class]
)
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun networkComponent(): NetworkComponent

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}