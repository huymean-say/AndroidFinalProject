//package com.movies
//
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Refresh
//import androidx.compose.material3.CenterAlignedTopAppBar
//import androidx.compose.material3.CircularProgressIndicator
//import androidx.compose.material3.Divider
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import coil.compose.AsyncImage
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MovieScaffold(vm: com.movies.MovieViewModel) {
//    Scaffold(
//        modifier = Modifier.fillMaxSize(),
//        topBar = {
//            CenterAlignedTopAppBar(
//                title = {
//                    Text("TOP Movie", modifier = Modifier, textAlign = TextAlign.Center)
//                },
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = Color(0xFFF9A825)
//                ),
//                actions = {
//                    IconButton(
//                        onClick = {
//                            vm.getResultList()
//                        }) {
//                        Icon(
//                            Icons.Default.Refresh,
//                            contentDescription = "Refresh",
//                        )
//                    }
//                }
//            )
//        }
//    ) {
//        Surface(modifier = Modifier.padding(it)) {
//            MovieBody(vm)
//        }
//    }
//}
//
//@Composable
//fun MovieBody(vm: com.movies.MovieViewModel) {
//    LaunchedEffect(Unit) {
//        vm.getResultList(100)
//    }
//
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        if (vm.isLoading) {
//            CircularProgressIndicator()
//        } else if (vm.errorMessage.isNotEmpty()) {
//            Text(vm.errorMessage)
//        } else {
//            LazyColumn(modifier = Modifier.fillMaxHeight()) {
//                items(vm.resultList.size) {
//
//                    val element = vm.resultList[it]
//
//                    Column(modifier = Modifier.padding(10.dp)) {
//                        Row(verticalAlignment = Alignment.CenterVertically) {
//
//                            Surface(modifier = Modifier.size(120.dp)) {
//                                AsyncImage(
//                                    model = element.fullPosterPath(),
//                                    contentDescription = element.fullPosterPath(),
//                                )
//                            }
//
//                            Box(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .padding(10.dp)
//                            ) {
//                                Column() {
//                                    Text("Title: ${element.title}")
//                                    Text("Release Date: ${element.releaseDate}")
//                                    Text("Rate: ${element.voteAverage}")
//                                }
//                            }
//                        }
//                        Divider()
//                    }
//                }
//            }
//        }
//    }
//}