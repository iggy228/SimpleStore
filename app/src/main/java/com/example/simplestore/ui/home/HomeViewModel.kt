package com.example.simplestore.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {
    private val _searchInput = MutableLiveData("")
    val searchInput: LiveData<String> get() = _searchInput

    fun setSearchInput(value: String) {
        _searchInput.value = value
    }
}