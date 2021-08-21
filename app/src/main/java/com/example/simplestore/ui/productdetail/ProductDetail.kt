package com.example.simplestore.ui.productdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.simplestore.R
import com.example.simplestore.models.Product

@Composable
fun ProductDetail() {
    val product = Product(1, "balon", "lietajuci plat", 0.19f, 10, null)

    Scaffold(
        floatingActionButton = { FloatingActionButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Default.Add, null)
        }}
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .scrollable(
                    rememberScrollState(),
                    orientation = Orientation.Vertical
                )
        ) {
            Image(
                painter = if (product.imageUrl == null) painterResource(R.drawable.placeholder)
                else rememberImagePainter(product.imageUrl),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().height(250.dp)
            )
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        product.name,
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier.weight(1f),
                        fontWeight = FontWeight.Bold
                    )
                    Icon(
                        Icons.Outlined.StarBorder,
                        null,
                        modifier = Modifier.size(40.dp)
                    )
                }
                Divider(color = Color.Gray, modifier = Modifier.fillMaxWidth())
                Spacer(Modifier.height(8.dp))
                Text(
                    product.fullDescription ?: product.shortDescription,
                    modifier = Modifier.weight(1f)
                )
                Spacer(Modifier.height(16.dp))
                Text("${product.price}€", style = MaterialTheme.typography.h6)
                Text("${product.weight}g")
            }
        }
    }
}