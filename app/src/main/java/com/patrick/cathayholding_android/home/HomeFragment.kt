package com.patrick.cathayholding_android.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.patrick.cathayholding_android.NavigationDirections
import com.patrick.cathayholding_android.R
import com.patrick.cathayholding_android.data.DisplayArea
import com.patrick.cathayholding_android.databinding.HomeFragmentBinding
import com.patrick.cathayholding_android.ext.getVmFactory


class HomeFragment : Fragment() {

    private val viewModel by viewModels <HomeViewModel> {getVmFactory()}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = HomeFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        val adapter = HomeAdapter(HomeAdapter.OnClickListener{
            it.let {
                findNavController().navigate(HomeFragmentDirections.actionHomeToDetailFragment(it))
            }
        })
        binding.homeRecyclerView.adapter = adapter
        viewModel.animalCategory.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        viewModel.displayArea.observe(viewLifecycleOwner, Observer {
            it?.let {
            }
        })

        return binding.root
    }

}
