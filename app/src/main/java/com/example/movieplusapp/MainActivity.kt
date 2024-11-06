package com.example.movieplusapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieplusapp.ui.theme.MoviePlusAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           MoviePlusApp()
        }
    }
}

@Composable
fun MoviePlusApp(){
    Column(modifier = Modifier.fillMaxSize()) {
        Section("Recommended  for you")
        Section("New movies/series")
        Section("Popular")
    }
}

@Composable
fun Section(title: String){
    Column (modifier = Modifier.padding(16.dp)){
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        LazyRow {
            items(5) {
                MovieItem()
            }
        }
    }
}

@Composable
fun MovieItem(){
    val context = LocalContext.current
    Box (
        modifier = Modifier
            .size(120.dp)
            .padding(8.dp)
            .clickable {
                // show message
                Toast
                    .makeText(context, "Playing movie", Toast.LENGTH_SHORT)
                    .show()
                // here add logic to play movie
            }
    ){
        //placeholder image
        Image(painter = painterResource(R.drawable.transformers), contentDescription = "Movie Thumbnail",
            modifier = Modifier.fillMaxSize())
    }
}

@Preview(showBackground = true)
@Composable
fun MoviePlusPreview() {
    MoviePlusApp()
}