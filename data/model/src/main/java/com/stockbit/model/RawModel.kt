package com.stockbit.model


import com.google.gson.annotations.SerializedName

data class RawModel(
    @SerializedName("IDR")
    val idr: CurrencyXModel?
)