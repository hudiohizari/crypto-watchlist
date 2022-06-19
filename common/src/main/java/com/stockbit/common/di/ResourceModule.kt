package com.stockbit.common.di

import com.stockbit.common.provider.ResourcesProvider
import org.koin.dsl.module

val resourceModule = module {

    single { ResourcesProvider(get()) }

}