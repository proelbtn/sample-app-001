package com.proelbtn.sampleapp001.data

import com.proelbtn.sampleapp001.api.StoreService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class StoreRepository @Inject constructor(
    private val storeDataSource: StoreService
) {
    fun list(): Flow<List<Store>> = flow {
        val response = storeDataSource.list()
        emit(response.body().orEmpty())
    }
}
