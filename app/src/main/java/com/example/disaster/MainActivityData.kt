package com.example.disaster

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.disaster.database.Disaster

class MainActivityData : ViewModel() {
    // Private LiveData variable to hold a list of Disaster objects
    private val _data = MutableLiveData<List<Disaster>>()

    // Public LiveData variable to observe the list of Disaster objects
    val data: LiveData<List<Disaster>> = _data

    // Function to set the value of the LiveData with a list of Disaster objects
    fun setData(data: List<Disaster>) {
        _data.value = data
    }
}