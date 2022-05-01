package com.proelbtn.sampleapp001.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proelbtn.sampleapp001.data.Store
import com.proelbtn.sampleapp001.data.StoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StoreViewModel @Inject constructor(
    private val storeRepository: StoreRepository
): ViewModel() {
    private val _stores = MutableStateFlow(listOf<Store>())
    val stores: StateFlow<List<Store>> = _stores

    fun fetchShop() {
        viewModelScope.launch {
            storeRepository.list()
                .collect {
                    _stores.value = it
                }

        }
    }
}