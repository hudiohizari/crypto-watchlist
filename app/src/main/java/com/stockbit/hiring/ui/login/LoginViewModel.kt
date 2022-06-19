package com.stockbit.hiring.ui.login

import com.stockbit.common.base.BaseViewModel
import com.stockbit.repository.AppDispatchers
import com.stockbit.repository.MainRepositoryImpl

class LoginViewModel(
    private val dispatchers: AppDispatchers,
    private val repository: MainRepositoryImpl
): BaseViewModel() {

}