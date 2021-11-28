package com.wilies.juza.ui.technology

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation.findNavController
import com.wilies.juza.adapters.SourcesScreenAdapter
import com.wilies.juza.databinding.FragmentSourcesBinding
import com.wilies.juza.interactions.SourceCardClickListener

class FragmentSources : Fragment() {
    private var sourceName: String = ""
    val viewModel: TechnologyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentSourcesBinding.inflate(inflater, container, false)
        val adapter = SourcesScreenAdapter(SourceCardClickListener {
            sourceName = it
            viewModel.startNavigating()
        })
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewmodel = viewModel
        binding.sourcesRecycler.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.navigating.observe(viewLifecycleOwner, Observer {

            if(it){
                viewModel.finishNavigating()
                val action = FragmentSourcesDirections
                    .actionNavigationTechSourcesToFragementArticlesBySource(sourceName)
                findNavController(view).navigate(action)

            }
        })
    }
}