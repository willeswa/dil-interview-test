package com.wilies.juza.ui.technology

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation.findNavController
import com.wilies.juza.MainActivity
import com.wilies.juza.adapters.HeadlinesScreenAdapter
import com.wilies.juza.databinding.FragmentTechnologyBinding
import com.wilies.juza.interactions.ArticleCardClickListener
import com.wilies.juza.utils.Utility

class FragmentTechnology : Fragment() {
    val viewModel: TechnologyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTechnologyBinding.inflate(inflater, container, false)
        val adapter = HeadlinesScreenAdapter(ArticleCardClickListener {
            activity?.let { activity -> Utility.openArticleAt(it, activity) }
        })
        binding.viewmodel = viewModel
        binding.techArticlesRecycler.adapter = adapter
        binding.lifecycleOwner = viewLifecycleOwner


        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.navigating.observe(viewLifecycleOwner, Observer{
            if(it){
                val action = FragmentTechnologyDirections
                    .actionNavigationTechnologyToFragmentSources()
                findNavController(view).navigate(action)
                viewModel.finishNavigating()
            }
        })
    }


}