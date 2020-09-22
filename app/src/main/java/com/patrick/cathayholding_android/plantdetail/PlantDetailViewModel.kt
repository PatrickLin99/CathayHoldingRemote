package com.patrick.cathayholding_android.plantdetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.patrick.cathayholding_android.data.PlantItem
import com.patrick.cathayholding_android.data.source.CathayHoldingRepository

class PlantDetailViewModel(private val repository: CathayHoldingRepository) : ViewModel() {

    val plantDetail = MutableLiveData<PlantItem>()

}
