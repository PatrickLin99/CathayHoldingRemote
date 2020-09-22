package com.patrick.cathayholding_android.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.patrick.cathayholding_android.data.AnimalCategory
import com.patrick.cathayholding_android.data.PlantInfo
import com.patrick.cathayholding_android.data.Result
import com.patrick.cathayholding_android.data.source.CathayHoldingRepository
import com.patrick.cathayholding_android.data.Plant
import com.patrick.cathayholding_android.data.PlantItem
import com.patrick.cathayholding_android.network.LoadApiStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: CathayHoldingRepository) : ViewModel() {

    val displayDetail = MutableLiveData<AnimalCategory>()

    private val _displayPlant = MutableLiveData<Plant>()

    val displayPlant: LiveData<Plant>
        get() = _displayPlant

    private val _displayPlantInfo = MutableLiveData<PlantInfo>()

    val displayPlantInfo: LiveData<PlantInfo>
        get() = _displayPlantInfo

    private val _displayPlantItem = MutableLiveData<List<PlantItem>>()

    val displayPlantItem: LiveData<List<PlantItem>>
        get() = _displayPlantItem

    private val _status = MutableLiveData<LoadApiStatus>()

    val status: LiveData<LoadApiStatus>
        get() = _status

    private val _error = MutableLiveData<String>()

    val error: LiveData<String>
        get() = _error

    private val _refreshStatus = MutableLiveData<Boolean>()

    val refreshStatus: LiveData<Boolean>
        get() = _refreshStatus

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun getDisplayPlantResult(animalArea: String) {

        coroutineScope.launch {

            val result = repository.getApiPlant(animalArea)

            _displayPlant.value = when (result) {

                is Result.Success -> {
                    _error.value = null
                    _status.value = LoadApiStatus.DONE
                    _displayPlantItem.value = result.data.result.results
                    result.data
                }
                is Result.Fail -> {
                    _error.value = result.error
                    _status.value = LoadApiStatus.ERROR
                    null
                }
                is Result.Error -> {
                    _error.value = result.exception.toString()
                    _status.value = LoadApiStatus.ERROR
                    null
                }
                else -> {
                    _error.value = ("R.string.you_know_nothing")
                    _status.value = LoadApiStatus.ERROR
                    null
                }
            }
        }
    }
}
