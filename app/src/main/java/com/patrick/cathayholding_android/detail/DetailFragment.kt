package com.patrick.cathayholding_android.detail

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
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.patrick.cathayholding_android.NavigationDirections
import com.patrick.cathayholding_android.R
import com.patrick.cathayholding_android.data.AnimalCategory
import com.patrick.cathayholding_android.databinding.DetailFragmentBinding
import com.patrick.cathayholding_android.ext.getVmFactory
import com.patrick.cathayholding_android.home.HomeViewModel
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.internal.notifyAll

class DetailFragment : Fragment() {

    private val viewModel by viewModels<DetailViewModel> { getVmFactory( ) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DetailFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.displayDetail.value =
            DetailFragmentArgs.fromBundle(requireArguments()).animalCategory
        DetailFragmentArgs.fromBundle(requireArguments()).animalCategory?.name?.let {
            viewModel.getDisplayPlantResult(
                it
            )
        }

        val adapter = DetailAdapter(DetailAdapter.OnClickListener {
            findNavController().navigate(
                DetailFragmentDirections.actionDetailFragmentToPlantDetailFragment(
                    it
                )
            )
        })
        binding.recyclerViewPlant.adapter = adapter
        viewModel.displayPlantItem.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        return binding.root
    }

    override fun onResume() {
        (activity as AppCompatActivity).image_back?.visibility = View.VISIBLE
        (activity as AppCompatActivity).image_list?.visibility = View.INVISIBLE
        (activity as AppCompatActivity).main_title.text =
            DetailFragmentArgs.fromBundle(requireArguments()).animalCategory?.name
        (activity as AppCompatActivity).image_back.setOnClickListener {
            findNavController().navigateUp()
            (activity as AppCompatActivity).image_back?.visibility = View.INVISIBLE
            (activity as AppCompatActivity).image_list?.visibility = View.VISIBLE
            (activity as AppCompatActivity).main_title.text = "台北市立動物園"
        }
        super.onResume()
    }
}
