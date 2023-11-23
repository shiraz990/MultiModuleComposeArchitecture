package com.core.network.di

import com.core.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    fun provideApiService():ApiService
    {
        return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
    }
}