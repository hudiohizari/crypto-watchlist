package com.stockbit.hiring.ui.watchlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.stockbit.common.base.BaseViewModel
import com.stockbit.model.list.CoinListModel
import com.stockbit.repository.MainRepositoryImpl
import com.stockbit.repository.utils.Resource
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class WatchlistViewModel(
    private val repository: MainRepositoryImpl
): BaseViewModel() {

    val fetchCoinsResponse = MutableLiveData<Resource<MutableList<CoinListModel>>>()
    val page = MutableLiveData(0)
    val isRefreshing = MutableLiveData(false)

    fun onRefresh() {
        isRefreshing.postValue(true)
        page.postValue(0)
        fetchCoins(0)
    }

    fun fetchCoins(page: Int?) {
        viewModelScope.launch {
            repository.getCoins(page).collect {
                if (it.status != Resource.Status.LOADING) isRefreshing.postValue(false)
                fetchCoinsResponse.postValue(it)
            }
        }
    }

}