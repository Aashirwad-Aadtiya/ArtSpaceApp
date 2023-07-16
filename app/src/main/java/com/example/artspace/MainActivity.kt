package com.example.artspace

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Space()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Space() {
    val page1 by remember{mutableStateOf(0)}
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(
                    text = stringResource(R.string.AppTitle),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 15.dp),
                    fontWeight = FontWeight.ExtraBold
                ) },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.LightGray,
                    titleContentColor = Color.DarkGray,
                ),
                modifier = Modifier.height(60.dp)
            )
        },
        content = {
            Surface(
                color = Color.DarkGray,
                shadowElevation = 4.dp,
                modifier = Modifier
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Spacer(modifier = Modifier.height(0.dp))
                    ImageDisplay(R.drawable.pexels_artem_beliaikin_853199)
                    ArtInfo()
                    ButtonDisplay(Page = page1)
                }
            }
        }
    )
}

@Composable
fun ImageDisplay(
    ImageName:Int
){
    Image(
        painter = painterResource(ImageName),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(16.dp, Color.White)
    )
}

@Composable
fun ArtInfo(){
    Column(
        modifier = Modifier.fillMaxWidth()
    ){
        Text(
            text = "Artwork Title",
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(8.dp),
            color = Color.White
        )
        Text(
            text = "Artist (year)",
            fontSize = 18.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 8.dp),
            color = Color.White
        )
    }
}

@Composable
fun ButtonDisplay( Page: Int){
    var page = Page
    Row(
        modifier = Modifier.fillMaxWidth()
    ){
        Spacer(modifier = Modifier.width(30.dp))
        Button(
            onClick = {
                if (page >=1) {page--}
            },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .height(60.dp)
        ){
            Text(text= stringResource(R.string.previous))
        }
        Spacer(modifier = Modifier.width(80.dp))
        Button(
            onClick = {
                if (page <6) {page++}
            },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .height(60.dp)
        ){
            Text(text= stringResource(R.string.next))
        }
        Spacer(modifier = Modifier.width(30.dp))
    }
}

@Preview(showBackground = false)
@Composable
fun SpacePreview() {
    ArtSpaceTheme {
        Space()
    }
}