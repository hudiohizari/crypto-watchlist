package com.stockbit.hiring.ui.login

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.stockbit.common.provider.ResourcesProvider
import com.stockbit.common.base.BaseViewModel
import com.stockbit.common.extension.toast
import com.stockbit.common.utils.ValidatorInput.INPUT_PASSWORD_MIN
import com.stockbit.common.utils.ValidatorInput.INPUT_USERNAME_EMAIL_MIN
import com.stockbit.common.utils.ValidatorInput.checkMinimumLengthError
import com.stockbit.hiring.R

class LoginViewModel(
    private val resourcesProvider: ResourcesProvider
): BaseViewModel() {

    val usernameEmail = MutableLiveData<String>()
    val usernameEmailError = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val passwordError = MutableLiveData<String>()
    val isButtonEnabled = MutableLiveData(false)

    fun checkButton() {
        val usernameEmailOk = checkMinimumLengthError(
            resourcesProvider.getString(R.string.username_or_email_error),
            usernameEmail,
            usernameEmailError,
            INPUT_USERNAME_EMAIL_MIN
        )
        val passwordOk = checkMinimumLengthError(
            resourcesProvider.getString(R.string.password_error),
            password,
            passwordError,
            INPUT_PASSWORD_MIN
        )
        val enabled = usernameEmailOk && passwordOk
        isButtonEnabled.postValue(enabled)
    }

    @Suppress("unused")
    fun View.onClickedGoogle() {
        context.toast("onClickedGoogle")
    }

    @Suppress("unused")
    fun View.onClickedFacebook() {
        context.toast("onClickedFacebook")
    }

    @Suppress("unused")
    fun View.onClickedForgotPassword() {
        context.toast("onClickedForgotPassword")
    }

    @Suppress("unused")
    fun View.onClickedLogin() {
        navigate(LoginFragmentDirections.actionSearchUserFragmentToUserDetailFragment())
    }

    @Suppress("unused")
    fun View.onClickedSignInWithFingerprint() {
        context.toast("onClickedSignInWithFingerprint")
    }

}