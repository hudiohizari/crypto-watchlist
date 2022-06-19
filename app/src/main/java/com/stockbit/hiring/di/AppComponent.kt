package com.stockbit.hiring.di

import com.stockbit.local.di.localModule
import com.stockbit.remote.BuildConfig
import com.stockbit.remote.di.createRemoteModule
import com.stockbit.repository.di.repositoryModule

val appComponent = listOf(
    createRemoteModule(BuildConfig.BASE_URL),
    repositoryModule,
    localModule,
    viewModelModule
)