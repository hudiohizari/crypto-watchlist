package com.stockbit.hiring.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.stockbit.common.base.BaseFragment
import com.stockbit.common.base.BaseViewModel
import com.stockbit.common.extension.setupClickableText
import com.stockbit.common.extension.toast
import com.stockbit.hiring.R
import com.stockbit.hiring.databinding.FragmentLoginBinding
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModel()

    private var v: View? = null

    override fun getViewModel(): BaseViewModel = viewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (view == null) {
            binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_login,
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

        initObservable()
        initView()
    }

    private fun initObservable() {
        viewModel.apply {
            usernameEmail.observe(viewLifecycleOwner) { checkButton() }
            password.observe(viewLifecycleOwner) { checkButton() }
        }
    }

    private fun initView() {
        // Register now
        val originText = getString(R.string.dont_have_an_account_yet)
        val clickableTexts = arrayOf(getString(R.string.dont_have_an_account_yet_highlight))
        val onClicks = arrayOf({
            requireContext().toast("onClickedRegisterNow")
        })
        val highlightedColors = arrayOf(R.color.colorAccent)
        binding.tvRegister.setupClickableText(originText, clickableTexts, onClicks, highlightedColors)
    }

}