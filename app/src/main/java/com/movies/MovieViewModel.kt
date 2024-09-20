package com.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class MovieViewModel : ViewModel() {
    private val _movies = MutableStateFlow<List<Results>>(emptyList())
    val movies: StateFlow<List<Results>> = _movies

    private val _errorMessage = MutableStateFlow("")
    val errorMessage: StateFlow<String> = _errorMessage

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun getResultList(page: Int = 1) {
        viewModelScope.launch {
            _isLoading.value = true
            val service = MovieService.getInstance()
            try {
                val movieResponse = service.getMovies(page = page)
                _movies.value = movieResponse.results
            } catch (e: Exception) {
                _errorMessage.value = e.message.toString()
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun searchMovies(query: String) {
        viewModelScope.launch {
            if (query.isBlank()) {
                _movies.value = emptyList()
                return@launch
            }

            _isLoading.value = true
            val service = MovieService.getInstance()
            try {
                val movieResponse = service.searchMovies(query = query)
                _movies.value = movieResponse.results
            } catch (e: Exception) {
                _errorMessage.value = e.message.toString()
            } finally {
                _isLoading.value = false
            }
        }
    }
}

