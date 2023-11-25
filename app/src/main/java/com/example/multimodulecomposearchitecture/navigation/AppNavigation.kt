package com.example.multimodulecomposearchitecture.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.core.common.navigation_constants.MovieFeature

@Composable
fun AppNavGraph(navigationController: NavHostController,
                navigationProvider: NavigationProvider) {

    NavHost(navController = navigationController, startDestination = MovieFeature.nestedRoute){
        navigationProvider.movieApi.registerGraph(navigationController,this)
    }
}