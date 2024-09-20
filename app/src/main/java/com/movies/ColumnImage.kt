//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.CircularProgressIndicator
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.unit.dp
//import coil.compose.AsyncImage
//
//@Composable
//fun ColumnImage(vm: com.movies.MovieViewModel) {
//    val movieState by vm.movies.collectAsState()
//    val isLoading by vm.isLoading.collectAsState()
//    val errorMessage by vm.errorMessage.collectAsState()
//
//    LaunchedEffect(Unit) {
//        if (movieState.isEmpty()) {
//            vm.getResultList()
//        }
//    }
//
//    Box(
//        modifier = Modifier
//            .background(Color.Black)
//            .fillMaxSize(),
//        contentAlignment = Alignment.TopCenter
//    ) {
//        Column(
//            modifier = Modifier.fillMaxSize()
//        ) {
//            when {
//                isLoading -> {
//                    CircularProgressIndicator(modifier = Modifier.size(50.dp))
//                }
//                errorMessage.isNotEmpty() -> {
//                    Text("Error: $errorMessage", color = Color.Red)
//                }
//                movieState.isEmpty() -> {
//                    Text("No movies available")
//                }
//                else -> {
//                    movieState.forEach { movie ->
//                        val imageUrl = "https://image.tmdb.org/t/p/w500${movie.posterPath}"
//                        Box(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(5.dp)
//                                .height(300.dp)  // Set the height to 300.dp
//                                .clip(RoundedCornerShape(20.dp))
//                        ) {
//                            AsyncImage(
//                                model = imageUrl,
//                                contentDescription = null,
//                                contentScale = ContentScale.Crop,
//                                modifier = Modifier.fillMaxSize()
//                            )
//                        }
//                    }
//                }
//            }
//        }
//    }
//}

//=======================================================

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.navigation.NavController
import com.movies.MovieViewModel

@Composable
fun ColumnImage(vm: MovieViewModel, navController: NavController) {
    val movieState by vm.movies.collectAsState()
    val isLoading by vm.isLoading.collectAsState()
    val errorMessage by vm.errorMessage.collectAsState()

    LaunchedEffect(Unit) {
        if (movieState.isEmpty()) {
            vm.getResultList()
        }
    }

    Box(
        modifier = Modifier
            .background(Color(0xFF0A0E21))
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            when {
                isLoading -> {
                    CircularProgressIndicator(modifier = Modifier.size(50.dp))
                }
                errorMessage.isNotEmpty() -> {
                    Text("Error: $errorMessage", color = Color.Red)
                }
                movieState.isEmpty() -> {
                    Text("No movies available")
                }
                else -> {
                    movieState.forEach { movie ->
                        val imageUrl = "https://image.tmdb.org/t/p/w500${movie.posterPath}"
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp)
                                .height(300.dp)  // Set the height to 300.dp
                                .clip(RoundedCornerShape(20.dp))
                                .clickable {
                                    navController.navigate("details/${movie.id}")
                                }
                        ) {
                            AsyncImage(
                                model = imageUrl,
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }
            }
        }
    }
}
