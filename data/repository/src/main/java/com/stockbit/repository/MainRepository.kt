package com.stockbit.repository

import com.stockbit.local.dao.CoinListDao
import com.stockbit.model.list.CoinListModel
import com.stockbit.remote.MainDatasource
import com.stockbit.repository.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

interface MainRepository {
    suspend fun getCoins(page: Int?): Flow<Resource<MutableList<CoinListModel>>>
}

class MainRepositoryImpl(
    private val dispatchers: AppDispatchers,
    private val datasource: MainDatasource,
    private val dao: CoinListDao
    ): MainRepository {

    override suspend fun getCoins(page: Int?): Flow<Resource<MutableList<CoinListModel>>> {
        return flow {
            emit(Resource.loading(null))
            try {
                val result = datasource.fetchCoinsAsync(page)
                if (result.isSuccessful) {
                    val cleanResponse = mutableListOf<CoinListModel>()
                    result.body()?.data?.forEach { cleanResponse.add(CoinListModel.convertFrom(it)) }
                    emit(Resource.success(cleanResponse))
                } else emit(Resource.error(Throwable(result.body()?.message), null))
            } catch (e: Exception) {
                emit(Resource.error(e, null))
            }
        }.flowOn(dispatchers.io)
    }

}