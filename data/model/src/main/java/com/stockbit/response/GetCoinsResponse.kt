package com.stockbit.response


import com.google.gson.annotations.SerializedName
import com.stockbit.model.CoinModel
import com.stockbit.model.MetaDataModel
import com.stockbit.model.RateLimitModel

data class GetCoinsResponse(
    @SerializedName("Data")
    val data: MutableList<CoinModel>?,
    @SerializedName("HasWarning")
    val hasWarning: Boolean?,
    @SerializedName("Message")
    val message: String?,
    @SerializedName("MetaData")
    val metaData: MetaDataModel?,
    @SerializedName("RateLimit")
    val rateLimit: RateLimitModel?,
    @SerializedName("SponsoredData")
    val sponsoredData: MutableList<CoinModel>?,
    @SerializedName("Type")
    val type: Int?
)