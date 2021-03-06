package com.stockbit.remote

class MainDatasource(private val mainService: MainService) {

    suspend fun fetchCoinsAsync(
        page: Int?,
        limit: Int?,
        currency: String? = "IDR"
    ) = mainService.fetchCoins(limit, page, currency)

}