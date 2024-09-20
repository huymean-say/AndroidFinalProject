package com.movies

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun MovieList(movies: List<Results>, onMovieClick: (Results) -> Unit = {}) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        LazyColumn {
            items(movies) { movie ->
                MovieItem(movie = movie, onClick = onMovieClick)
            }
        }
    }
}

@Composable
fun MovieItem(movie: Results, onClick: (Results) -> Unit = {}) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick(movie) },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            movie.posterPath?.let {
                Image(
                    painter = rememberImagePainter(movie.fullPosterPath()),
                    contentDescription = "Movie Poster",
                    modifier = Modifier
                        .size(100.dp)
                        .padding(8.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = movie.title,
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "Rating: ${movie.voteAverage}/10",
                    fontSize = 16.sp,
                    color = Color.Gray,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start
                )

                // Display the release date
                val releaseDate = movie.getReleaseDateAsDate()
                releaseDate?.let {
                    Text(
                        text = "Release Date: ${SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(it)}",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewMovieItem() {
    val sampleMovie = Results(
        adult = false,
        backdropPath = "/path_to_backdrop.jpg",
        genreIds = listOf(),
        id = 1,
        originalLanguage = "en",
        originalTitle = "Sample Movie",
        overview = "This is a sample movie overview.",
        popularity = 9.5,
        posterPath = "/path_to_poster.jpg",
        releaseDate = "2023-09-20",
        title = "Sample Movie",
        video = false,
        voteAverage = 8.0,
        voteCount = 1000
    )
    MovieItem(movie = sampleMovie)
}
