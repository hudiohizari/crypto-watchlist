package com.stockbit.common.provider

import android.content.Context
import androidx.annotation.StringRes

class ResourcesProvider(
    private val context: Context
) {
    fun getString(@StringRes stringResId: Int): String {
        return context.getString(stringResId)
    }
}