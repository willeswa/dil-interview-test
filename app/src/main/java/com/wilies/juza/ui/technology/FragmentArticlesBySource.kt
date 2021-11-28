package com.wilies.juza.ui.technology

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.wilies.juza.R
import com.wilies.juza.adapters.HeadlinesScreenAdapter
import com.wilies.juza.databinding.FragmentArticlesBySourceBinding
import com.wilies.juza.interactions.ArticleCardClickListener
import com.wilies.juza.utils.Utility

class FragmentArticlesBySource : Fragment() {
    val viewModel: TechnologyViewModel by viewModels()
    val args: FragmentArticlesBySourceArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getArticlesPublishedBy(args.sourceName)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentArticlesBySourceBinding.inflate(inflater, container, false)

        (activity as AppCompatActivity).supportActionBar?.title = "Published by ${args.sourceName}"

        val adapter = HeadlinesScreenAdapter(ArticleCardClickListener {
            activity?.let { activity -> Utility.openArticleAt(it, activity) }
        })

        binding.techSourceRecycler.adapter = adapter
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }



}