package com.langlab.demos.download

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.langlab.demos.R
import com.langlab.demos.databinding.FragmentDownloadBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DownloadFragment : Fragment(R.layout.fragment_download) {

    private lateinit var binding: FragmentDownloadBinding
    private val viewModel: DownloadViewModel by viewModels()

    companion object {
        @JvmStatic
        fun newInstance() = DownloadFragment().apply {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDownloadBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url = "https://www.warrantylife.com/bundles/warrantylifesite/images/home/black-broken-phones.jpg"

        binding.button1.setOnClickListener {
            viewModel.state.observe(viewLifecycleOwner, showState)
            viewModel.downloadFile(url)
        }

        binding.button2.setOnClickListener {
        }
    }

    private val showState = Observer<String> {
        binding.textView1.text = it
    }
}