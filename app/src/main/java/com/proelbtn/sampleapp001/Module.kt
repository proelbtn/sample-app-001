package com.proelbtn.sampleapp001

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
class Module {
    @Provides
    fun moshi(): Moshi = Moshi.Builder()
        .build()

    @Provides
    fun retrofit(moshi: Moshi): Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl("https://fakestoreapi.com")
        .build()

    @Provides
    fun storeDataStore(retrofit: Retrofit): StoreDataStore = retrofit.create()
}