package com.stockbit.model


import com.google.gson.annotations.SerializedName

data class RatingModel(
    @SerializedName("Weiss")
    val weiss: WeissModel?
)