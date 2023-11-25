package com.feature.movie.data.repo

import com.feature.movie.domain.model.Movie
import com.core.network.dataproviders.MovieDataProviders
import com.feature.movie.data.mapper.toDomainMovieList
import com.feature.movie.domain.repo.MovieRepository
import javax.inject.Inject

class MovieRepoImpl @Inject constructor(private val movieDataProvider:MovieDataProviders) : MovieRepository {
    override suspend fun getMovieList(apiKey: String, q: String): List<Movie> {
        return movieDataProvider.getMovieList(apiKey,q).toDomainMovieList()
    }
}