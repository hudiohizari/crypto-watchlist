package com.stockbit.common.extension

import android.content.Context
import android.widget.Toast
import com.stockbit.common.R

fun Context.toast(message: String?) {
    Toast.makeText(
        this,
        message ?: getString(R.string.empty_text),
        Toast.LENGTH_SHORT
    ).show()
}