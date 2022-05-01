package com.proelbtn.sampleapp001

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class StoreRepository @Inject constructor(
    private val storeDataSource: StoreDataStore
) {
    fun list(): Flow<List<Store>> = flow {
        val response = storeDataSource.list()
        emit(response.body().orEmpty())
    }
}