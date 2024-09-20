package com.movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings

@Composable
fun Profile() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        ProfileHeader()
        Spacer(modifier = Modifier.height(16.dp))
        ProfileStats()
        Spacer(modifier = Modifier.height(16.dp))
        AboutSection()
        Spacer(modifier = Modifier.height(16.dp))
        PostsGrid()
    }
}

@Composable
fun ProfileHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Profile Picture and Name
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = rememberAsyncImagePainter("https://i.mydramalist.com/Z8v3B7_3f.jpg"), // replace with real image
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape), // Circular profile image
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text("Huymean Say", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text("@_huymean_21_", color = Color.Gray, fontSize = 16.sp)
            }
        }

        // Settings Icon Button
        IconButton(onClick = { /* Handle settings click */ }) {
            Icon(Icons.Filled.Settings, contentDescription = "Settings", tint = Color.Gray)
        }
    }
}

@Composable
fun ProfileStats() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        StatItem("50", "Posts")
        StatItem("2024", "Followers")
        StatItem("202", "Following")
    }
}

@Composable
fun StatItem(count: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = count, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text(text = label, color = Color.Gray, fontSize = 14.sp)
    }
}

@Composable
fun AboutSection() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            text = "About",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Hello I'm Huymean Say, I am a Android Developer...!",
            color = Color.Gray,
            fontSize = 14.sp,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun PostsGrid() {
    val movieList = listOf(
        "https://press-start.com.au/wp-content/uploads/2023/01/spider-man-2-770x433.jpg",
        "https://upload.wikimedia.org/wikipedia/en/d/d6/Superman_Man_of_Steel.jpg",
        "https://static.wikia.nocookie.net/marvel_dc/images/a/a2/Batman_Vol_3_124_Textless.jpg/revision/latest?cb=20220608034122",
        "https://m.media-amazon.com/images/M/MV5BNzg1MDQxMTQ2OF5BMl5BanBnXkFtZTcwMTk3MjAzOQ@@._V1_.jpg",
        "https://comicvine.gamespot.com/a/uploads/original/11/117763/2590208-cyclops.jpg",
        "https://images.bild.de/5d519306f46f5000016c9e95/4f8760285839da1bd4911c48d10d95fa,311290ef?w=992",
        "https://assets-prd.ignimgs.com/2023/12/21/xmen-97-001-cov-1703186917214.jpg",
        "https://upload.wikimedia.org/wikipedia/en/2/21/Web_of_Spider-Man_Vol_1_129-1.png",
        "https://m.media-amazon.com/images/M/MV5BZWVhYzE0NzgtM2U1Yi00OWM1LWJlZTUtZmNkNWZhM2VkMDczXkEyXkFqcGdeQW1yb3NzZXI@._V1_QL75_UY281_CR16,0,500,281_.jpg",
        "https://static.wikia.nocookie.net/marvel_dc/images/a/a2/Batman_Vol_3_124_Textless.jpg/revision/latest?cb=20220608034122",
        "https://m.media-amazon.com/images/M/MV5BNzg1MDQxMTQ2OF5BMl5BanBnXkFtZTcwMTk3MjAzOQ@@._V1_.jpg",
        "https://comicvine.gamespot.com/a/uploads/original/11/117763/2590208-cyclops.jpg",
        "https://static.wikia.nocookie.net/dccu/images/6/6f/JL_Wonder_Woman.jpg/revision/latest?cb=20160914003449",
        "https://assets-prd.ignimgs.com/2023/12/21/xmen-97-001-cov-1703186917214.jpg",
        "https://upload.wikimedia.org/wikipedia/en/2/21/Web_of_Spider-Man_Vol_1_129-1.png",
        "https://upload.wikimedia.org/wikipedia/en/d/d6/Superman_Man_of_Steel.jpg",
        "https://static.wikia.nocookie.net/marvel_dc/images/a/a2/Batman_Vol_3_124_Textless.jpg/revision/latest?cb=20220608034122",
        "https://m.media-amazon.com/images/M/MV5BNzg1MDQxMTQ2OF5BMl5BanBnXkFtZTcwMTk3MjAzOQ@@._V1_.jpg",
        "https://comicvine.gamespot.com/a/uploads/original/11/117763/2590208-cyclops.jpg",
        "https://static.wikia.nocookie.net/dccu/images/6/6f/JL_Wonder_Woman.jpg/revision/latest?cb=20160914003449",
        "https://assets-prd.ignimgs.com/2023/12/21/xmen-97-001-cov-1703186917214.jpg"
    )

    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            text = "Posts",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3), // 3 columns for the grid
            contentPadding = PaddingValues(4.dp),
            modifier = Modifier.height(300.dp) // Adjust this height as needed
        ) {
            items(movieList) { imageUrl ->
                Image(
                    painter = rememberAsyncImagePainter(imageUrl),
                    contentDescription = "Post Image",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .padding(4.dp)
                        .clip(RoundedCornerShape(10.dp)), // Rounded corners with 10.dp
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewProfile() {
    Profile()
}
