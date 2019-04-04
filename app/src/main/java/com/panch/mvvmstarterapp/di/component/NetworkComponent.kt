package com.panch.mvvmstarterapp.di.component

import com.panch.mvvmstarterapp.base.BaseViewModel
import com.panch.mvvmstarterapp.di.module.NetworkModule
import com.panch.mvvmstarterapp.di.scope.NetworkScope
import dagger.Subcomponent

@NetworkScope
@Subcomponent(
    modules = [NetworkModule::class]
)
interface NetworkComponent {
    fun inject(target: BaseViewModel)
}