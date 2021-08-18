package com.example.simplestore

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.simplestore.ui.home.Home
import com.example.simplestore.ui.theme.SimpleStoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SimpleStoreTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Home()
                }
            }
        }
    }
}

@Preview(name = "Light theme")
@Preview(name = "Dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun Preview() {
    SimpleStoreTheme {
        Surface(color = MaterialTheme.colors.background) {
            Home()
        }
    }
}