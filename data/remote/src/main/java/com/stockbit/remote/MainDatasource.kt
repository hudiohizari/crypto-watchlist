package com.stockbit.remote

class MainDatasource(private val mainService: MainService) {

    fun fetchTopUsersAsync(
        limit: Int?,
        page: Int?,
        currency: String? = "USD"
    ) = mainService.fetchCoins(limit, page, currency)

}