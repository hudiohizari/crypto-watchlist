package com.stockbit.common.utils

import androidx.lifecycle.MutableLiveData

object ValidatorInput {

    const val INPUT_USERNAME_EMAIL_MIN = 4
    const val INPUT_PASSWORD_MIN = 8

    fun checkMinimumLengthError(
        errorText: String,
        data: MutableLiveData<String>,
        errorData: MutableLiveData<String>,
        minLength: Int
    ): Boolean {
        return if(!data.value.isNullOrEmpty()) {
            if((data.value?.length ?: 0) < minLength) {
                if(errorData.value != errorText) errorData.postValue(errorText)
                false
            } else {
                if(errorData.value != null) errorData.postValue(null)
                true
            }
        } else {
            if(errorData.value != null) errorData.postValue(null)
            false
        }
    }

}