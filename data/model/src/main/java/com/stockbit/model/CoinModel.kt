package com.stockbit.model


import com.google.gson.annotations.SerializedName

data class CoinModel(
    @SerializedName("CoinInfo")
    val coinInfo: CoinInfoModel?,
    @SerializedName("DISPLAY")
    val display: DisplayModel?,
    @SerializedName("RAW")
    val raw: RawModel?
)