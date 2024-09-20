package com.movies

sealed class Screens (val screen: String){
    data object Home: Screens("home")
    data object Search: Screens("search")
    data object About: Screens("about")
    data object Profile: Screens("profile")

    //=====================
    data object Details : Screens("details/{movieId}") {
        fun createRoute(movieId: String) = "details/$movieId"
    }
    data object Popular : Screens("popular")
    data object Upcoming : Screens("upcoming")
    data object NowPlaying : Screens("now_playing")
}