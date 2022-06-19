package com.stockbit.hiring.ui.watchlist.list

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import com.stockbit.common.adapter.DiffableListItemType
import com.stockbit.model.list.CoinListModel
import com.stockbit.hiring.databinding.ListItemCoinBinding

class CoinListItem(
    private val model: CoinListModel
) : AbstractBindingItem<ListItemCoinBinding>(), DiffableListItemType {

    override fun itemIdentifier(): Any = model.name

    override fun comparableContents(): List<Any?> = listOf(
        model.name,
        model.fullName,
        model.price,
        model.diff24Hour,
        model.changes24Hour
    )

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): ListItemCoinBinding {
        return ListItemCoinBinding.inflate(inflater, parent, false)
    }

    override val type: Int get() = hashCode()

    override fun bindView(binding: ListItemCoinBinding, payloads: List<Any>) {
        binding.item = model
    }
}