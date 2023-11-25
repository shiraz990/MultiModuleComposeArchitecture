package com.example.multimodulecomposearchitecture.di

import com.example.multimodulecomposearchitecture.navigation.NavigationProvider
import com.feature.movie.ui.navigation.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideNavigationProvider(movieApi: MovieApi):NavigationProvider{
         return  NavigationProvider(movieApi)
    }
}