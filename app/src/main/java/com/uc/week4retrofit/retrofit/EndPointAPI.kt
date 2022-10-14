package com.uc.week4retrofit.retrofit

import com.uc.week4retrofit.model.MovieDetails
import com.uc.week4retrofit.model.NowPlaying
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface EndPointAPI {

    @GET("movie/now_playing")
    suspend fun getNowPlaying(
        @Query("api_key")apikey: String,
        @Query("language")language: String,
        @Query("page")page: Int,
//        @Query("region")region: String
    ):Response<NowPlaying>

    @GET("movie/{movie_Id}")
    suspend fun getMovieDetails(
        @Path("movie_Id") Id:Int,
        @Query("api_key")apikey: String
    ): Response<MovieDetails>
}