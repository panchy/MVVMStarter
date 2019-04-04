package com.panch.mvvmstarterapp.di.module


import com.panch.mvvmstarterapp.data.rest.RestApi
import com.panch.mvvmstarterapp.data.rest.createRestClient
import com.panch.mvvmstarterapp.di.scope.NetworkScope
import dagger.Module
import dagger.Provides


@Module
class NetworkModule {
    @NetworkScope
    @Provides
    fun provideRestClient(): RestApi = createRestClient()
}