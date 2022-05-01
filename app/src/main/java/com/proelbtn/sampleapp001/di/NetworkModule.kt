package com.proelbtn.sampleapp001.di

import com.proelbtn.sampleapp001.api.StoreService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder()
        .build()

    @Provides
    fun provideRetrofit(moshi: Moshi): Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl("https://fakestoreapi.com")
        .build()

    @Provides
    fun provideStoreDataStore(retrofit: Retrofit): StoreService = retrofit.create()
}
