package com.stockbit.model

import com.google.gson.annotations.SerializedName

data class CurrencyModel(
    @SerializedName("CHANGE24HOUR")
    val change24Hour: String?,
    @SerializedName("CHANGEDAY")
    val changeDay: String?,
    @SerializedName("CHANGEHOUR")
    val changeHour: String?,
    @SerializedName("CHANGEPCT24HOUR")
    val changePercentage24Hour: String?,
    @SerializedName("CHANGEPCTDAY")
    val changePercentageDay: String?,
    @SerializedName("CHANGEPCTHOUR")
    val changePercentageHour: String?,
    @SerializedName("CIRCULATINGSUPPLY")
    val circulatingSupply: String?,
    @SerializedName("CIRCULATINGSUPPLYMKTCAP")
    val circulatingSupplyMarketCap: String?,
    @SerializedName("CONVERSIONSYMBOL")
    val conversionSymbol: String?,
    @SerializedName("CONVERSIONTYPE")
    val conversionType: String?,
    @SerializedName("FROMSYMBOL")
    val fromSymbol: String?,
    @SerializedName("HIGH24HOUR")
    val high24Hour: String?,
    @SerializedName("HIGHDAY")
    val highDay: String?,
    @SerializedName("HIGHHOUR")
    val highHour: String?,
    @SerializedName("IMAGEURL")
    val imageUrl: String?,
    @SerializedName("LASTMARKET")
    val lastMarket: String?,
    @SerializedName("LASTTRADEID")
    val lastTradeId: String?,
    @SerializedName("LASTUPDATE")
    val lastUpdate: String?,
    @SerializedName("LASTVOLUME")
    val lastVolume: String?,
    @SerializedName("LASTVOLUMETO")
    val lastVolumeTo: String?,
    @SerializedName("LOW24HOUR")
    val low24Hour: String?,
    @SerializedName("LOWDAY")
    val lowDay: String?,
    @SerializedName("LOWHOUR")
    val lowHour: String?,
    @SerializedName("MARKET")
    val market: String?,
    @SerializedName("MKTCAP")
    val mktCap: String?,
    @SerializedName("MKTCAPPENALTY")
    val mktCapPenalty: String?,
    @SerializedName("OPEN24HOUR")
    val open24Hour: String?,
    @SerializedName("OPENDAY")
    val openDay: String?,
    @SerializedName("OPENHOUR")
    val openHour: String?,
    @SerializedName("PRICE")
    val price: String?,
    @SerializedName("SUPPLY")
    val supply: String?,
    @SerializedName("TOPTIERVOLUME24HOUR")
    val topTierVolume24Hour: String?,
    @SerializedName("TOPTIERVOLUME24HOURTO")
    val topTierVolume24HourTo: String?,
    @SerializedName("TOSYMBOL")
    val toSymbol: String?,
    @SerializedName("TOTALTOPTIERVOLUME24H")
    val totalTopTierVolume24Hour: String?,
    @SerializedName("TOTALTOPTIERVOLUME24HTO")
    val totalTopTierVolume24HourTo: String?,
    @SerializedName("TOTALVOLUME24H")
    val totalVolume24Hour: String?,
    @SerializedName("TOTALVOLUME24HTO")
    val totalVolume24HourTo: String?,
    @SerializedName("VOLUME24HOUR")
    val volume24Hour: String?,
    @SerializedName("VOLUME24HOURTO")
    val volume24HourTo: String?,
    @SerializedName("VOLUMEDAY")
    val volumeDay: String?,
    @SerializedName("VOLUMEDAYTO")
    val volumeDayTo: String?,
    @SerializedName("VOLUMEHOUR")
    val volumeHour: String?,
    @SerializedName("VOLUMEHOURTO")
    val volumeHourTo: String?
)