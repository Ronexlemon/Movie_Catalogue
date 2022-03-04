package com.example.movie


import com.example.movie.apiinsta.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {

    @GET("/3/movie/popular?api_key=fa6fa8b9a8c18aa739a7ea525f6da97b")
    fun getMovie(): Call<MovieResponse>
}
