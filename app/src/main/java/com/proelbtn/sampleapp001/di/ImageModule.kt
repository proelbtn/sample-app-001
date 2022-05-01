package com.proelbtn.sampleapp001.di

import android.content.Context
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext

@InstallIn(ActivityComponent::class)
@Module
class ImageModule {
    @Provides
    fun providePicasso(@ActivityContext context: Context): Picasso = Picasso.Builder(context)
        .build()
}