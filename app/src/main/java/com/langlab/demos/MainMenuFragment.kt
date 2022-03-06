package com.langlab.demos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.langlab.demos.databinding.FragmentMainMenuBinding
import com.langlab.demos.download.DownloadFragment

class MainMenuFragment : Fragment(R.layout.fragment_main_menu) {

    private lateinit var binding: FragmentMainMenuBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainMenuFragment().apply {
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.downloadButton.setOnClickListener {
            val fragment = DownloadFragment()
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, fragment, "fragmnetId")?.commit();
        }
    }
}