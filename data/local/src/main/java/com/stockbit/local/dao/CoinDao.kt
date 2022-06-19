package com.stockbit.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.stockbit.model.list.CoinListModel

@Dao
abstract class CoinListDao: BaseDao<CoinListModel>() {

    @Query("SELECT * FROM CoinListModel WHERE name = :name LIMIT 1")
    abstract fun getExample(name: String): CoinListModel

    suspend fun save(data: CoinListModel) {
        insert(data)
    }

    suspend fun save(datas: List<CoinListModel>) {
        insert(datas)
    }
}