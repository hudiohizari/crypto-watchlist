package com.stockbit.hiring.ui.watchlist.list

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import com.stockbit.common.adapter.DiffableListItemType
import com.stockbit.common.extension.loadingAnimation
import com.stockbit.hiring.databinding.ListItemLoadingCoinBinding

class CoinLoadingListItem :
    AbstractBindingItem<ListItemLoadingCoinBinding>(),
    DiffableListItemType {

    override fun itemIdentifier(): Any = this.hashCode()

    override fun comparableContents(): List<Any> = listOf()

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): ListItemLoadingCoinBinding {
        return ListItemLoadingCoinBinding.inflate(inflater, parent, false)
    }

    override val type: Int get() = hashCode()

    override fun bindView(binding: ListItemLoadingCoinBinding, payloads: List<Any>) {
        super.bindView(binding, payloads)
        binding.vName.loadingAnimation()
        binding.vFullName.loadingAnimation()
        binding.vPrice.loadingAnimation()
        binding.vPriceChanges.loadingAnimation()
    }
}