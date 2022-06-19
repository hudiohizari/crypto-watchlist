package com.stockbit.hiring.di

import com.stockbit.hiring.ui.login.LoginViewModel
import com.stockbit.hiring.ui.watchlist.WatchlistViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { LoginViewModel(get()) }
    viewModel { WatchlistViewModel(get()) }

}