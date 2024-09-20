//package com.movies
//
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import coil.compose.AsyncImage
//import com.movies.Results
//
//
//@Composable
//fun MovieCard(movie:Results) {
//    Card(
//        shape = RoundedCornerShape(16.dp),
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp),
//        colors = CardDefaults.cardColors(containerColor = Color(0xFF1C1C28))
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Box(
//                modifier = Modifier
//                    .size(100.dp)
//                    .clip(RoundedCornerShape(5.dp))
//            ) {
//                AsyncImage(
//                    model = movie.fullPosterPath(),
//                    contentDescription = movie.title,
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier.fillMaxSize()
//                )
//            }
//
//            Spacer(modifier = Modifier.width(16.dp))
//
//            Column(
//                modifier = Modifier.weight(1f)
//            ) {
//                Text(
//                    text = movie.title,
//                    color = Color.White,
//                    fontSize = 18.sp,
//                    fontWeight = FontWeight.Bold
//                )
//                Spacer(modifier = Modifier.height(4.dp))
//                Text(
//                    text = movie.releaseDate,
//                    color = Color.Gray,
//                    fontSize = 14.sp
//                )
//                Spacer(modifier = Modifier.height(8.dp))
//
//                Button(
//                    onClick = { /* Handle click */ },
//                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
//                    shape = RoundedCornerShape(24.dp),
//                    modifier = Modifier.align(Alignment.Start)
//                ) {
//                    Text(
//                        text = "Watch Now",
//                        color = Color.White,
//                        fontSize = 14.sp
//                    )
//                }
//            }
//        }
//    }
//}
