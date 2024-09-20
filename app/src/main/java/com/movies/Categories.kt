import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.movies.Screens

//package com.movies
//
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//@Composable
//fun Categories(){
//    Column (
//        modifier = Modifier
//            .fillMaxSize()
//    ){
//        Text(
//            text = "Categories",
//            modifier = Modifier.padding(10.dp),
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color.White,
//        )
//        Row (
//            modifier = Modifier.fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceAround
//        ){
//            Button(
//                onClick = { /*TODO*/ },
//                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
//                shape = RoundedCornerShape(20.dp),
//                modifier = Modifier.padding(5.dp)
//            ) {
//                Text(text = "Popular")
//            }
//
//            Button(
//                onClick = { /*TODO*/ },
//                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
//                shape = RoundedCornerShape(20.dp),
//                modifier = Modifier.padding(5.dp)
//            ) {
//                Text(text = "Upcoming")
//            }
//            Button(
//                onClick = { /*TODO*/ },
//                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
//                shape = RoundedCornerShape(20.dp),
//                modifier = Modifier.padding(5.dp)
//            ) {
//                Text(text = "Playing")
//            }
//        }
//    }
//}

//==============================================

@Composable
fun Categories(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Categories",
            modifier = Modifier.padding(10.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = {
                    Log.d("Categories", "Navigating to Popular Screen")
                    navController.navigate(Screens.Popular.screen) },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.padding(5.dp)
            ) {
                Text(text = "Popular")
            }

            Button(
                onClick = { navController.navigate(Screens.Popular.screen) },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.padding(5.dp)
            ) {
                Text(text = "Upcoming")
            }

            Button(
                onClick = { navController.navigate(Screens.Popular.screen)},
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.padding(5.dp)
            ) {
                Text(text = "Playing")
            }
        }
    }
}
