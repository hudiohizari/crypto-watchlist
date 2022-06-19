package com.stockbit.model


import com.google.gson.annotations.SerializedName

data class DisplayModel(
    @SerializedName("USD")
    val usd: CurrencyModel?
)