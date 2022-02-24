package com.project.multiscreenjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.multiscreenjetpackcompose.ui.theme.MultiScreenJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Screen()
        }
    }
}

@Composable
private fun Screen() {
    MultiScreenJetpackComposeTheme {
        val windowInfo = rememberWindowInfo()

        when (windowInfo.screenWidthInfo) {
            WindowInfo.WindowType.Compact -> {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(10) {
                        Text(
                            text = "Item $it",
                            fontSize = 25.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    Color.Cyan
                                )
                                .padding(16.dp)
                        )
                    }

                    items(10) {
                        Text(
                            text = "Item $it",
                            fontSize = 25.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    Color.Green
                                )
                                .padding(16.dp)
                        )
                    }
                }
            }
            else -> {
                Row(modifier = Modifier.fillMaxSize().background(Color.DarkGray)) {
                    LazyColumn(modifier = Modifier.weight(1f)) {
                        items(10) {
                            Text(
                                text = "Item $it",
                                fontSize = 25.sp,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(
                                        Color.Cyan
                                    )
                                    .padding(16.dp)
                            )
                        }
                    }

                    LazyColumn(modifier = Modifier.weight(1f)) {
                        items(10) {
                            Text(
                                text = "Item $it",
                                fontSize = 25.sp,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(
                                        Color.Green
                                    )
                                    .padding(16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    MultiScreenJetpackComposeTheme {
        Screen()
    }
}

@Preview(device = Devices.AUTOMOTIVE_1024p, widthDp = 1024, heightDp = 720,showBackground = true, showSystemUi = true)
@Composable
fun DefaultLandscapePreview() {
    MultiScreenJetpackComposeTheme {
        Screen()
    }
}