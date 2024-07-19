package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerTheme {
                Surface {
                    TaskManagerBase(
                        image = R.drawable.ic_task_completed,
                        title = R.string.tasks_completed_text,
                        text = R.string.nice_work_text,
                        modifier = Modifier,
                    )
                }
            }
        }
    }
}

@Composable
fun TaskManagerBase(image: Int, title: Int, text: Int, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TaskManagerImage(image, modifier)
        TaskManagerTitle(title, modifier)
        TaskManagerText(text, modifier)
    }
}

@Composable
fun TaskManagerImage(image: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = image),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = modifier
    )
}

@Composable
fun TaskManagerTitle(title: Int, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = title),
        fontWeight = FontWeight.Bold,
        modifier = modifier.padding(top = 24.dp, bottom = 8.dp)
    )
}

@Composable
fun TaskManagerText(text: Int, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = text),
        fontSize = 16.sp,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun TaskManagerPreview() {
    TaskManagerTheme {
        TaskManagerBase(
            image= R.drawable.ic_task_completed,
            title = R.string.tasks_completed_text,
            text = R.string.nice_work_text)
    }
}