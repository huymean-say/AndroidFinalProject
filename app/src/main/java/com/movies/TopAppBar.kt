//package com.movies
//
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Refresh
//import androidx.compose.material3.CenterAlignedTopAppBar
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun composeTopAppBar(vm: com.movies.MovieViewModel) {
//    Scaffold(
//        topBar = {
//            CenterAlignedTopAppBar(
//                title = {
//                    Text("TOP Movie")
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
//        }
//    }
//}
//
