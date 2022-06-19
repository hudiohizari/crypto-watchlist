package com.stockbit.remote

import com.stockbit.response.GetCoinsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MainService {

    @GET("data/top/totaltoptiervolfull")
    suspend fun fetchCoins(
        @Query("limit") limit: Int?,
        @Query("page") page: Int?,
        @Query("tsym") currency: String?
    ): Response<GetCoinsResponse>

}