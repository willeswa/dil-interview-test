package com.wilies.juza.ui.technology

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wilies.juza.R

class FragmentTechnology : Fragment() {

    companion object {
        fun newInstance() = FragmentTechnology()
    }

    private lateinit var viewModel: FragmentTechnologyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_technology, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FragmentTechnologyViewModel::class.java)
        // TODO: Use the ViewModel
    }

}