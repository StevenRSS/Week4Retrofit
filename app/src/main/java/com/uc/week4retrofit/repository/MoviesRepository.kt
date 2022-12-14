package com.uc.week4retrofit.repository

import com.uc.week4retrofit.retrofit.EndPointAPI
import javax.inject.Inject

class MoviesRepository @Inject constructor(private val api: EndPointAPI) {

    suspend fun getNowPlayingData(apiKey: String, language: String, page: Int)
    = api.getNowPlaying(apiKey, language, page)

    suspend fun getMovieDetailsData(apiKey: String, movieId: Int)
    = api.getMovieDetails(movieId, apiKey)
}