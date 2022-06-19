package com.stockbit.model.list

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.stockbit.model.CoinModel
import com.stockbit.model.R

@Entity
data class CoinListModel(
    @PrimaryKey
    val name: String,
    val fullName: String? = null,
    val price: String? = null,
    val diff24Hour: String? = null,
    val changes24Hour: String? = null
) {

    fun getChanges(): String {
        return "$diff24Hour ($changes24Hour%)"
    }

    fun getChangesColor(context: Context): Int {
        return ContextCompat.getColor(
            context,
            if (diff24Hour?.contains("-") == true) R.color.colorFailed else R.color.colorAccent
        )
    }

    companion object {
        fun convertFrom(coin: CoinModel): CoinListModel {
            return CoinListModel(
                coin.coinInfo?.name ?: hashCode().toString(),
                coin.coinInfo?.fullName,
                coin.display?.idr?.price,
                coin.display?.idr?.change24Hour,
                coin.display?.idr?.changePercentage24Hour
            )
        }
    }

}