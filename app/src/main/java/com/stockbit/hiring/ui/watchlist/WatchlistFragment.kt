package com.stockbit.hiring.ui.watchlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.stockbit.common.base.BaseFragment
import com.stockbit.common.base.BaseViewModel
import com.stockbit.hiring.R
import com.stockbit.hiring.databinding.FragmentWatchlistBinding
import org.koin.android.viewmodel.ext.android.viewModel

class WatchlistFragment : BaseFragment() {

    private lateinit var binding: FragmentWatchlistBinding
    private val viewModel: WatchlistViewModel by viewModel()

    private var v: View? = null

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

}