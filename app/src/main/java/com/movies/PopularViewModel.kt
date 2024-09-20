//package com.movies
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//
//class PopularViewModel : ViewModel() {
//    private val movieService = MovieService.getInstance()
//
//    private val _movies = MutableStateFlow<List<Results>>(emptyList())
//    val movies: StateFlow<List<Results>> = _movies
//
//    init {
//        fetchMovies()
//    }
//
//    private fun fetchMovies() {
//        viewModelScope.launch {
//            try {
//                val response = movieService.getMovies()
//                _movies.value = response.results
//            } catch (e: Exception) {
//                // Handle exceptions
//            }
//        }
//    }
//}
