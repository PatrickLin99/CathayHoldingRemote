package com.patrick.cathayholding_android.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.patrick.cathayholding_android.data.AnimalCategory
import com.patrick.cathayholding_android.data.DisplayArea
import com.patrick.cathayholding_android.data.DisplayAreaResults
import com.patrick.cathayholding_android.data.source.CathayHoldingRepository
import com.patrick.cathayholding_android.network.LoadApiStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import com.patrick.cathayholding_android.data.Result

class HomeViewModel(private val repository: CathayHoldingRepository) : ViewModel() {

    private val _displayArea = MutableLiveData<DisplayArea>()

    val displayArea: LiveData<DisplayArea>
        get() = _displayArea

    private val _displayAreaResults = MutableLiveData<DisplayAreaResults>()

    val displayAreaResults: LiveData<DisplayAreaResults>
        get() = _displayAreaResults

    private val _animalCategory = MutableLiveData<List<AnimalCategory>>()

    val animalCategory: LiveData<List<AnimalCategory>>
        get() = _animalCategory

    private val _navigateToDetail = MutableLiveData<DisplayArea>()

    val navigateToDetail: LiveData<DisplayArea>
    get() = _navigateToDetail

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

    init {
        getDisplayAreaResult()
    }

    private fun getDisplayAreaResult() {

        coroutineScope.launch {


            val result = repository.getApiAreas()

            _displayArea.value = when (result) {

                is Result.Success -> {
                    _error.value = null
                    _status.value = LoadApiStatus.DONE
                    _animalCategory.value = result.data.result.results
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
