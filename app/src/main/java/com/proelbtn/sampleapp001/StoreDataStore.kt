package com.proelbtn.sampleapp001

import retrofit2.Response
import retrofit2.http.GET

interface StoreDataStore {
    @GET("products")
    suspend fun list(): Response<List<Store>>
}