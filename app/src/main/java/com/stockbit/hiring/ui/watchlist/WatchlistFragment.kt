package com.stockbit.hiring.ui.watchlist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import com.stockbit.common.adapter.*
import com.stockbit.common.base.BaseFragment
import com.stockbit.common.base.BaseViewModel
import com.stockbit.common.extension.toast
import com.stockbit.hiring.R
import com.stockbit.hiring.databinding.FragmentWatchlistBinding
import com.stockbit.hiring.ui.watchlist.list.CoinListItem
import com.stockbit.hiring.ui.watchlist.list.CoinLoadingListItem
import com.stockbit.model.list.CoinListModel
import com.stockbit.repository.utils.Resource
import org.koin.android.viewmodel.ext.android.viewModel

class WatchlistFragment : BaseFragment() {

    private lateinit var binding: FragmentWatchlistBinding
    private val viewModel: WatchlistViewModel by viewModel()

    private var v: View? = null

    private lateinit var itemDecoration: DividerItemDecoration

    private val coins = mutableListOf<CoinListModel>()

    override fun getViewModel(): BaseViewModel = viewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (view == null) {
            binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_watchlist,
                container,
                false
            )
            binding.viewModel = viewModel
            binding.lifecycleOwner = viewLifecycleOwner
            v = binding.root
        }

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObserver()
    }

    private fun initObserver() {
        viewModel.apply {
            fetchCoinsResponse.observe(viewLifecycleOwner) { res ->
                when (res.status) {
                    Resource.Status.LOADING -> processFetchCoinsLoading()
                    Resource.Status.SUCCESS -> processFetchCoinsSuccess(res.data ?: mutableListOf())
                    Resource.Status.ERROR -> {
                        Log.e("fetchCoinsResponse", "Resources.Error = ${res.error?.message}")
                        requireContext().toast("${res.error?.message}")
                        processFetchCoinsFailed()
                    }
                    else -> Log.e("fetchCoinsResponse", "Unhandled resource type")
                }
            }
            page.observe(viewLifecycleOwner) {
                if (it == 0) coins.clear()
                viewModel.fetchCoins(it)
            }
        }
    }

    private fun processFetchCoinsLoading() {
        if (viewModel.page.value == 0) {
            val items: MutableList<UnspecifiedTypeItem> = mutableListOf()
            for (i in 0..15) {
                items.add(CoinLoadingListItem())
            }
            getCoinAdapter().performUpdates(items)
        }
    }

    private fun processFetchCoinsSuccess(list: MutableList<CoinListModel>) {
        coins.addAll(list)
        val items: MutableList<UnspecifiedTypeItem> = mutableListOf()
        coins.forEach { items.add(CoinListItem(it)) }

        // 20 is the data limit
        if (coins.size >= 20) {
            items.add(DefaultLoadMoreListItem(object : DefaultLoadMoreListItem.Listener {
                override fun onLoadMore(isLoadMore: Boolean) {
                    var page = viewModel.page.value ?: 0
                    page++
                    if (isLoadMore) { viewModel.page.postValue(page) }
                }
            }))
        }

        if (coins.isEmpty()) {
            binding.rvCoin.removeItemDecoration(getItemDecoration())
            items.add(DefaultEmptyListItem(getString(R.string.data_empty)))
        } else {
            binding.rvCoin.addItemDecoration(getItemDecoration())
        }

        getCoinAdapter().performUpdates(items)
    }

    private fun processFetchCoinsFailed() {
        val items: MutableList<UnspecifiedTypeItem> = mutableListOf()
        coins.forEach { items.add(CoinListItem(it)) }
        items.add(DefaultReloadListItem(object : DefaultReloadListItem.Listener {
            override fun reload() { viewModel.fetchCoins(viewModel.page.value) }
        }))
        getCoinAdapter().performUpdates(items)
    }

    private fun getItemDecoration(): DividerItemDecoration {
        if (!::itemDecoration.isInitialized) {
            itemDecoration = DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        }
        return itemDecoration
    }

    private fun getCoinAdapter(): FastItemAdapter<UnspecifiedTypeItem> {
        if (binding.adapter == null) {
            binding.adapter = FastItemAdapter()
            binding.rvCoin.itemAnimator = null
        }
        return binding.adapter as FastItemAdapter
    }


}