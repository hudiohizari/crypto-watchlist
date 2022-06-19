package com.stockbit.model.list

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.stockbit.model.CoinModel

@Entity
data class CoinListModel(
    @PrimaryKey
    val name: String,
    val FullName: String? = null,
    val price: String? = null,
    val diff24Hour: String? = null,
    val changes24Hour: String? = null
) {

    companion object {
        fun convert(coin: CoinModel): CoinListModel {
            return CoinListModel(
                coin.coinInfo?.name ?: hashCode().toString(),
                coin.coinInfo?.fullName,
                coin.display?.usd?.price,
                coin.display?.usd?.change24Hour,
                coin.display?.usd?.changePercentage24Hour
            )
        }
    }

}