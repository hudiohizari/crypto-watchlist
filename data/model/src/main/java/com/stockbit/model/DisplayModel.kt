package com.stockbit.model


import com.google.gson.annotations.SerializedName

data class DisplayModel(
    @SerializedName("IDR")
    val idr: CurrencyModel?
)