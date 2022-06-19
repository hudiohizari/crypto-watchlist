package com.stockbit.hiring.ui.login

import com.stockbit.common.base.BaseViewModel
import com.stockbit.repository.AppDispatchers
import com.stockbit.repository.ExampleRepository
import com.stockbit.repository.ExampleRepositoryImpl

class LoginViewModel(
    private val dispatchers: AppDispatchers,
    private val repository: ExampleRepositoryImpl
): BaseViewModel() {

}