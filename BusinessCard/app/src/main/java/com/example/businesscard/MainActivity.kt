package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

/*
Color palette:
0xFF6B9080 - darkest green
0xFFA4C3B2
0xFFCCE3DE
0xFFEAF4F4
0xFFF6FFF8 - lightest green



 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFA4C3B2))
    ) {
        Image(
            painter = painterResource(id = R.drawable.it_worker_vertical),
            contentDescription = null,
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.Crop, // might not work with fillMaxWidth/Size
            modifier = Modifier.fillMaxWidth(),
        )

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            InitialInfo(name= "John Doe", title = "Android Developer", modifier = Modifier.padding(bottom = 16.dp))
            ContactInformation(modifier = Modifier.padding(top = 16.dp))
        }
    }
}

@Composable
fun InitialInfo(name: String = "Name", title: String = "Title", modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFF6FFF8))
            .padding(10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier//.fillMaxWidth()
        ) {
            Text(
                text = name,
                fontSize = 40.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                lineHeight = 40.sp,
                modifier = Modifier
            )
            Text(
                text = title,
                color = Color.DarkGray,
                fontSize = 20.sp,
                lineHeight = 20.sp,
                modifier = Modifier.padding(top = 8.dp),
                )
        }
    }
}

@Composable
fun ContactInformation(modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ) {
        InfoLinkSection(Icons.Rounded.Call, "+55 (82) 99721-3266")
        InfoLinkSection(Icons.Rounded.Email, "johndoe@gmail.com")
    }
}

@Composable
fun InfoLinkSection(icon: ImageVector, text: String, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Icon(
            icon,
            tint = Color.White,
            contentDescription = null,
            )
        Text(
            text = text,
            fontSize = 25.sp,
            lineHeight = 15.sp,
            color = Color.White,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.bodySmall.copy(
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset(1f,1f),
                    blurRadius = 5f,
                )
            ),
            modifier = Modifier.padding(start = 16.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ){
            BusinessCard()
        }
    }
}