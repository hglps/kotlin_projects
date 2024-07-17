package com.example.articleexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.articleexample.ui.theme.ArticleExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArticleExampleTheme {
                Surface(modifier = Modifier) {
                    ArticleExample(
                        imageFile = R.drawable.bg_compose_background,
                        title = R.string.article_title,
                        text1 = R.string.article_text_1,
                        text2 = R.string.article_text_2,
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@Composable
fun ArticleExample(imageFile: Int, title: Int, text1: Int, text2: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        ArticleImage(imageFile = imageFile)
        ArticleTitle(title = title, modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 16.dp))
        ArticleText(text = text1, modifier = Modifier.padding(start = 16.dp, end = 16.dp))
        ArticleText(text = text2, modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun ArticleImage(imageFile: Int, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = imageFile),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            alpha = 1.0F
        )
    }
}

@Composable
fun ArticleTitle(title: Int, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = title),
        fontSize = 24.sp,
        modifier = modifier
    )
}

@Composable
fun ArticleText(text: Int, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = text),
        textAlign = TextAlign.Justify,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArticleExampleTheme {
        ArticleExample(
            imageFile = R.drawable.bg_compose_background,
            title = R.string.article_title,
            text1 = R.string.article_text_1,
            text2 = R.string.article_text_2
        )
    }
}