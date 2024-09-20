import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.movies.MovieViewModel
import com.movies.Results

@Composable
fun RowImageHorizontal(vm: MovieViewModel, navController: NavController) {
    val movieList by vm.movies.collectAsState()
    val isLoading by vm.isLoading.collectAsState()
    val errorMessage by vm.errorMessage.collectAsState()

    LaunchedEffect(Unit) {
        if (movieList.isEmpty()) {
            vm.getResultList()
        }
    }

    when {
        isLoading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        errorMessage.isNotEmpty() -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Error: $errorMessage", color = Color.Red)
            }
        }
        else -> {
            RowImageHorizontal(movieList = movieList, navController = navController)
        }
    }
}

@Composable
fun RowImageHorizontal(movieList: List<Results>, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A0E21)),
        contentAlignment = Alignment.TopCenter
    ) {
        composeRowImageHorizontal(movieList, navController)
    }
}

@Composable
fun composeRowImageHorizontal(movieList: List<Results>, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        verticalAlignment = Alignment.CenterVertically
    ) {
        movieList.forEach { movie ->
            composeImageShapeHorizontal(movie, navController)
        }
    }
}

@Composable
fun composeImageShapeHorizontal(movie: Results, navController: NavController) {
    val imageUrl = movie.fullPosterPath()
    Surface(
        modifier = Modifier
            .height(300.dp)
            .width(300.dp)
            .padding(10.dp)
            .clickable {
                navController.navigate("details/${movie.id}")
            },
        color = Color(0xFF4527A0),
        shape = RoundedCornerShape(20.dp)
    ) {
        imageUrl?.let {
            AsyncImage(
                model = it,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}
