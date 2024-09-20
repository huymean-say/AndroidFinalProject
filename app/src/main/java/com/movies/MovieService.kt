//package com.movies
//
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.http.GET
//import retrofit2.http.Query
////https://api.themoviedb.org/3/movie/popular?language=en-US&page=1&api_key=f4f56297b747af1647a18d59bc332bbe
////https://api.themoviedb.org/3/movie/popular?api_key=f4f56297b747af1647a18d59bc332bbe
//const val BASE_URL = "https://api.themoviedb.org"
//interface MovieService {
//    @GET("3/movie/popular")
//    suspend fun getMovies(
//        @Query("language") language: String = "en-US",
//        @Query("page") page: Int = 1,
//        @Query("api_key") apiKey: String = "f4f56297b747af1647a18d59bc332bbe",
//    ): TheMovieDb
//
//    @GET("3/search/movie")
//    suspend fun searchMovies(
//        @Query("query") query: String,
//        @Query("language") language: String = "en-US",
//        @Query("page") page: Int = 1,
//        @Query("api_key") apiKey: String = "f4f56297b747af1647a18d59bc332bbe"
//    ): TheMovieDb
//
//    companion object {
//        var service : MovieService? = null
//        fun getInstance() : MovieService {
//            if (service == null){
//                service = Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//                    .create(MovieService::class.java)
//            }
//            return service!!
//        }
//    }
//}

package com.movies

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://api.themoviedb.org"

interface MovieService {
    @GET("3/movie/popular")
    suspend fun getMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = "f4f56297b747af1647a18d59bc332bbe"
    ): TheMovieDb

    @GET("3/search/movie")
    suspend fun searchMovies(
        @Query("query") query: String,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = "f4f56297b747af1647a18d59bc332bbe"
    ): TheMovieDb

    @GET("3/movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = "f4f56297b747af1647a18d59bc332bbe"
    ): TheMovieDb

    @GET("3/movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = "f4f56297b747af1647a18d59bc332bbe"
    ): TheMovieDb

    companion object {
        var service: MovieService? = null
        fun getInstance(): MovieService {
            if (service == null) {
                service = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(MovieService::class.java)
            }
            return service!!
        }
    }
}
