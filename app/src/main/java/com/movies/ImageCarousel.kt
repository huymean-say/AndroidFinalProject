package com.movies

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.launch
import java.io.IOException
import kotlin.math.absoluteValue

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageCarousel() {
    var imageUrls by remember { mutableStateOf<List<String>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf("") }
    val pagerState = rememberPagerState(pageCount = {imageUrls.size})

    // Launch a coroutine to fetch data
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        coroutineScope.launch {
            try {
                val service = MovieService.getInstance()
                val result = service.getMovies()
                imageUrls = result.results.map { it.fullPosterPath() }
                isLoading = false
            } catch (e: HttpException) {
                errorMessage = "HTTP Error: ${e.message}"
                isLoading = false
            } catch (e: IOException) {
                errorMessage = "Network Error: ${e.message}"
                isLoading = false
            }
        }
    }

    if (isLoading) {
        // Show a loading indicator
        CircularProgressIndicator()
    } else if (errorMessage.isNotEmpty()) {
        // Show an error message
        Text(text = errorMessage)
    } else {
        // Display carousel if images are loaded
        HorizontalPager(state = pagerState) { page ->
            Card(
                modifier = Modifier
                    .height(450.dp)
                    .fillMaxWidth()
                    .graphicsLayer {
                        val pageOffset = (
                                (pagerState.currentPage - page) + pagerState
                                    .currentPageOffsetFraction
                                ).absoluteValue

                        alpha = lerp(
                            start = 0.5f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    }
            ) {
                Box(
                    modifier = Modifier
                        .height(450.dp)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(imageUrls[page]),
                        contentDescription = "Movie Image",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}
