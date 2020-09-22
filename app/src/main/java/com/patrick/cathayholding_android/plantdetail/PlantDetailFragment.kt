package com.patrick.cathayholding_android.plantdetail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.patrick.cathayholding_android.NavigationDirections

import com.patrick.cathayholding_android.R
import com.patrick.cathayholding_android.data.PlantItem
import com.patrick.cathayholding_android.databinding.DetailFragmentBinding
import com.patrick.cathayholding_android.databinding.PlantDetailFragmentBinding
import com.patrick.cathayholding_android.detail.DetailFragmentArgs
import com.patrick.cathayholding_android.detail.DetailViewModel
import com.patrick.cathayholding_android.ext.getVmFactory
import kotlinx.android.synthetic.main.activity_main.*

class PlantDetailFragment : Fragment() {

    private val viewModel by viewModels<PlantDetailViewModel> { getVmFactory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = PlantDetailFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.plantDetail.value =
            PlantDetailFragmentArgs.fromBundle(requireArguments()).plantItem

        return binding.root
    }

    override fun onResume() {
        (activity as AppCompatActivity).image_back?.visibility = View.VISIBLE
        (activity as AppCompatActivity).image_list?.visibility = View.INVISIBLE
        (activity as AppCompatActivity).main_title.text =
            PlantDetailFragmentArgs.fromBundle(requireArguments()).plantItem.chinesename
        (activity as AppCompatActivity).image_back.setOnClickListener {
            findNavController().navigateUp()
        }
        super.onResume()
    }

    override fun onStop() {
        (activity as AppCompatActivity).image_back?.visibility = View.VISIBLE
        (activity as AppCompatActivity).image_list?.visibility = View.INVISIBLE
        super.onStop()
    }
}
