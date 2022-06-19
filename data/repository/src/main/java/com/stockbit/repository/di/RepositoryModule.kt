package com.stockbit.repository.di

import com.stockbit.repository.AppDispatchers
import com.stockbit.repository.MainRepositoryImpl
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val repositoryModule = module {
    factory { AppDispatchers(Dispatchers.Main, Dispatchers.IO) }
    factory { MainRepositoryImpl(get(), get(), get()) }
}