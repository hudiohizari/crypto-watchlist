package com.stockbit.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.stockbit.model.list.CoinListModel

@Dao
abstract class CoinListDao: BaseDao<CoinListModel>() {

    @Query("SELECT * FROM CoinListModel LIMIT :limit OFFSET :offset")
    abstract fun getCoins(limit: Int, offset: Int): MutableList<CoinListModel>

    fun save(data: CoinListModel) {
        insert(data)
    }

    fun save(datas: List<CoinListModel>) {
        insert(datas)
    }
}