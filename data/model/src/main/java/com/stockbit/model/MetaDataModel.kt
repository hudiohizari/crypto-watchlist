package com.stockbit.model


import com.google.gson.annotations.SerializedName

data class MetaDataModel(
    @SerializedName("Count")
    val count: Int?
)