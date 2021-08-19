package com.example.simplestore

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.simplestore.ui.home.Home
import com.example.simplestore.ui.productdetail.ProductDetail
import com.example.simplestore.ui.theme.SimpleStoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SimpleStore()
        }
    }
}

@Composable
fun SimpleStore() {
    val navController = rememberNavController()

    SimpleStoreTheme {
        Surface(color = MaterialTheme.colors.background) {
            NavHost(navController, startDestination = "home") {
                composable("home") {
                    Home(onProductClick = { navController.navigate("product") })
                }
                composable("product") { ProductDetail() }
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
            ProductDetail()
        }
    }
}