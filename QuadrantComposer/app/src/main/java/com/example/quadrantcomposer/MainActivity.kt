package com.example.quadrantcomposer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quadrantcomposer.ui.theme.QuadrantComposerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuadrantComposerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuadrantComposerBase(
                        titles = arrayOf(R.string.title_1, R.string.title_2, R.string.title_3, R.string.title_4),
                        texts = arrayOf(R.string.text_1, R.string.text_2, R.string.text_3, R.string.text_4),
                        )
                }
            }
        }
    }
}

@Composable
fun QuadrantComposerBase(titles: Array<Int>, texts: Array<Int>, modifier: Modifier = Modifier) {
    val titlesStr = titles.map { stringResource(id = it) }.toTypedArray()
    val textsStr = texts.map { stringResource(id = it) }.toTypedArray()
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row (
            modifier = modifier.weight(1f)
        ) {
            Quadrant(
                title = titlesStr.getOrNull(0) ?: "1",
                text = textsStr.getOrNull(0) ?: "11111111",
                color = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f))
            Quadrant(
                title = titlesStr.getOrNull(1) ?: "2",
                text = textsStr.getOrNull(1) ?: "22222222",
                color = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f))
        }
        Row (
            modifier = Modifier.weight(1f)
        ) {
            Quadrant(
                title = titlesStr.getOrNull(2) ?: "3",
                text = textsStr.getOrNull(2) ?: "33333333",
                color= Color(0xFFB69DF8),
                modifier = Modifier.weight(1f))
            Quadrant(
                title = titlesStr.getOrNull(3) ?: "4",
                text = textsStr.getOrNull(3) ?: "44444444",
                color = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun Quadrant(title: String, text: String, color: Color, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
//            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom=16.dp)
        // Critical point. If is 'modifier' instead of Modifier, it will not work properly.
        )
        Text(
            text = text,
            textAlign = TextAlign.Justify,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun QuadrantComposerPreview() {
    val quadrantTitles = arrayOf(R.string.title_1, R.string.title_2, R.string.title_3, R.string.title_4)
    val quadrantTexts = arrayOf(R.string.text_1, R.string.text_2, R.string.text_3, R.string.text_4)
    QuadrantComposerTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            QuadrantComposerBase(
                titles = quadrantTitles,
                texts = quadrantTexts,
            )
        }
    }
}