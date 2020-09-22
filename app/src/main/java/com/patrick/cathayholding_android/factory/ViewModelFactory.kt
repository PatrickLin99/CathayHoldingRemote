package com.patrick.cathayholding_android.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.patrick.cathayholding_android.data.source.CathayHoldingRepository
import com.patrick.cathayholding_android.detail.DetailViewModel
import com.patrick.cathayholding_android.home.HomeViewModel
import com.patrick.cathayholding_android.plantdetail.PlantDetailViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(
    private val repository: CathayHoldingRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(HomeViewModel::class.java) ->
                    HomeViewModel(repository)

                isAssignableFrom(DetailViewModel::class.java) ->
                    DetailViewModel(repository)

                isAssignableFrom(PlantDetailViewModel::class.java) ->
                    PlantDetailViewModel(repository)

                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}