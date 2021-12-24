package com.example.exponentiation.mvpdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.exponentiation.databinding.FragmentDetailsBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class DetailsFragment : MvpAppCompatFragment(), DetailsView {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private val presenter: DetailsPresenter by moxyPresenter {
        DetailsPresenter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.subscribe()
        with(binding) {
            sendButton.setOnClickListener {
                presenter.multiply(inputEditLogin.text.toString().toInt())
            }
        }
    }

    companion object {
        fun newInstance() = DetailsFragment()
    }

    override fun showResult(result: Int) {
        binding.textView.text = result.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}