package com.proelbtn.sampleapp001.api

import com.proelbtn.sampleapp001.data.Store
import retrofit2.Response
import retrofit2.http.GET

interface StoreService {
    @GET("products")
    suspend fun list(): Response<List<Store>>
}