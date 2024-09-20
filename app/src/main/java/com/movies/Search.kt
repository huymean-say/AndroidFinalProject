import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.movies.MovieList
import com.movies.MovieViewModel
import com.movies.SearchBox

@Composable
fun Search(vm: MovieViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A0E21)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        SearchBox(onSearchQueryChanged = { query ->
            vm.searchMovies(query)
        })

        val movies by vm.movies.collectAsState()
        if (movies.isNotEmpty()) {

            MovieList(movies)
        } else {
            Text("No results found", color = Color.White, modifier = Modifier.padding(16.dp))
        }
    }
}
