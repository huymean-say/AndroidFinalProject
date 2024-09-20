//package com.movies
//
//import android.text.Layout.Alignment
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.CircularProgressIndicator
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.unit.dp
//import coil.compose.AsyncImage
//import java.lang.reflect.Modifier
//
//@Composable
//fun Testing(vm: com.movies.MovieViewModel){
//    val movieList by remember { mutableStateOf(vm.resultList) }
//    val isLoading by remember { mutableStateOf(vm.isLoading) }
//    val errorMessage by remember { mutableStateOf(vm.errorMessage) }
//
//    LaunchedEffect(Unit) {
//        vm.getResultList()
//    }
//
//    if (isLoading) {
//        Box(
//            contentAlignment = Alignment.Center,
//            modifier = Modifier.fillMaxSize()
//        ) {
//            CircularProgressIndicator()
//        }
//    } else if (errorMessage.isNotEmpty()) {
//        Box(
//            contentAlignment = Alignment.Center,
//            modifier = Modifier.fillMaxSize()
//        ) {
//            Text(text = "Error: $errorMessage", color = Color.Red)
//        }
//    } else {
//        RowImageTop(movieList = movieList)
//    }
//}
//
//
//@Composable
//fun RowImageTop(movieList: List<Results>) {
//    Box(
//        modifier = Modifier
//            .background(Color.Black)
//            .fillMaxSize(),
//        contentAlignment = Alignment.TopCenter
//    ) {
//        composeRowImage(movieList)
//    }
//}
//
//@Composable
//fun composeRowImage(movieList: List<Results>) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .horizontalScroll(rememberScrollState()),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        movieList.forEach { movie ->
//            composeImageShape(movie.fullPosterPath())
//        }
//    }
//}
//
//@Composable
//fun composeImageShape(imageUrl: String?) {
//    Surface(
//        modifier = Modifier
//            .size(width = 150.dp, height = 250.dp)
//            .padding(3.dp),
//        color = Color(0xFF4527A0),
//        shape = RoundedCornerShape(20.dp)
//    ) {
//        imageUrl?.let {
//            AsyncImage(
//                model = it,
//                contentDescription = null,
//                contentScale = ContentScale.Crop
//            )
//        }
//    }
//}
