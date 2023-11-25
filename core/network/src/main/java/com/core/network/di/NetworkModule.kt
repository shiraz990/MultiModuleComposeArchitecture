package com.core.network.di

import android.os.Build
import com.core.network.ApiService
import com.core.network.BuildConfig
import com.core.network.dataproviders.MovieDataProviders
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    fun provideApiService():ApiService
    {
        return Retrofit.Builder().baseUrl(BuildConfig.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiService::class.java)
    }

    @Provides
    fun provideMovieDataProvider(apiService: ApiService):MovieDataProviders{
        return MovieDataProviders(apiService)
    }
}