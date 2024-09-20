package com.movies

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn // Import location icon
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun About() {
    Surface(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.padding(16.dp)) {
            item {

                Card(modifier = Modifier.padding(top = 8.dp)) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                            Text(
                                text = "About This App",
                                style = MaterialTheme.typography.titleLarge,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(modifier = Modifier.height(18.dp))
                        Text(
                            text = "This app allows users to explore and manage their favorite movies. " +
                                    "You can browse, add, and remove movies from your favorites list. " +
                                    "Enjoy discovering new films and sharing your favorites with friends!",
                            style = TextStyle(fontSize = 20.sp)
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                            Text(
                                text = "Contact Us:",
                                style = MaterialTheme.typography.titleMedium,
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        // Phone Section
                        Row(modifier = Modifier.padding(vertical = 4.dp)) {
                            Icon(Icons.Filled.Phone, contentDescription = "Phone Icon")
                            Text(text = " (855) 69 99 86 46", modifier = Modifier.padding(start = 8.dp))
                        }
                        // Email Section
                        Row(modifier = Modifier.padding(vertical = 4.dp)) {
                            Icon(Icons.Filled.Email, contentDescription = "Email Icon")
                            Text(text = " huymean0203@gmail.com", modifier = Modifier.padding(start = 8.dp))
                        }
                        // Location Section
                        Row(modifier = Modifier.padding(vertical = 4.dp)) {
                            Icon(Icons.Filled.LocationOn, contentDescription = "Location Icon")
                            Text(text = " Phnom Penh, Cambodia", modifier = Modifier.padding(start = 8.dp))
                        }
                    }
                }
            }
        }
    }
}
