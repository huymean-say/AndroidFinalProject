import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.movies.AllMovies
import com.movies.ImageCarousel
import com.movies.LatestMovies
import com.movies.MostPopular
import com.movies.MovieViewModel
import com.movies.Upcoming

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun Home(vm: MovieViewModel, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A0E21))
            .verticalScroll(rememberScrollState())
    ) {
        ImageCarousel()
        Categories(navController = navController)
        MostPopular()
        RowImageTop(vm = vm, navController = navController)
        LatestMovies()
        RowImageTop(vm = vm, navController = navController)
        Upcoming()
        RowImageHorizontal(vm = vm, navController = navController)
        AllMovies()
        ColumnImage(vm = vm, navController = navController)
    }
}
