package com.wilies.juza.ui.headlines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.wilies.juza.adapters.HeadlinesScreenAdapter
import com.wilies.juza.databinding.FragmentHeadlinesBinding
import com.wilies.juza.interactions.ArticleCardClickListener
import com.wilies.juza.utils.Utility

class HomeFragment : Fragment() {
    private var _binding: FragmentHeadlinesBinding? = null
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHeadlinesBinding.inflate(inflater, container, false)

        val adapter = HeadlinesScreenAdapter(ArticleCardClickListener{
            activity?.let{ activity ->
                Utility.openArticleAt(it, activity)
            }
        })
        _binding?.headlineRecycler?.adapter = adapter
        _binding?.lifecycleOwner = viewLifecycleOwner
        _binding?.viewmodel = viewModel

        return _binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}