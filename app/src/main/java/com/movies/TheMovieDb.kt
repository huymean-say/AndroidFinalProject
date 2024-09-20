package com.movies

import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


data class TheMovieDb (

    @SerializedName("page") var page : Int,
    @SerializedName("results") var results : List<Results>,
    @SerializedName("total_pages") var totalPages : Int,
    @SerializedName("total_results") var totalResults : Int

)
data class Results(

    @SerializedName("adult") var adult: Boolean,
    @SerializedName("backdrop_path") var backdropPath: String,
    @SerializedName("genre_ids") var genreIds: List<Int>,
    @SerializedName("id") var id: Int,
    @SerializedName("original_language") var originalLanguage: String,
    @SerializedName("original_title") var originalTitle: String,
    @SerializedName("overview") var overview: String,
    @SerializedName("popularity") var popularity: Double,
    @SerializedName("poster_path") var posterPath: String?,
    @SerializedName("release_date") var releaseDate: String,
    @SerializedName("title") var title: String,
    @SerializedName("video") var video: Boolean,
    @SerializedName("vote_average") var voteAverage: Double,
    @SerializedName("vote_count") var voteCount: Int

){
    fun fullPosterPath() = "https://image.tmdb.org/t/p/w500/$posterPath"

    fun getReleaseDateAsDate(): Date? {
        return try {
            SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(releaseDate.toString())
        } catch (e: Exception) {
            null
        }
    }
}