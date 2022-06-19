package com.stockbit.repository

import com.stockbit.local.dao.CoinListDao
import com.stockbit.remote.MainDatasource
import com.stockbit.repository.utils.Resource
import com.stockbit.response.GetCoinsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface MainRepository {
    suspend fun getExample(): Flow<Resource<GetCoinsResponse>>
}

class MainRepositoryImpl(private val datasource: MainDatasource,
                         private val dao: CoinListDao): MainRepository {

    override suspend fun getExample(): Flow<Resource<GetCoinsResponse>> {
        return flow {

        }
    }

}