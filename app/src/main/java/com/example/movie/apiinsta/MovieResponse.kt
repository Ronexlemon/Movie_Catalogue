package com.example.movie.apiinsta

import android.os.Parcelable
import com.example.movie.Movie
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class MovieResponse(
    @SerializedName("results")
    val movies : List<Movie>

)