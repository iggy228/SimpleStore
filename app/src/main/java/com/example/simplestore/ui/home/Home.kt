package com.example.simplestore.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.simplestore.R
import com.example.simplestore.models.Product

@Composable
fun ProductList(products: List<Product>, onClickItem: () -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(top = 8.dp)
    ) {
        items(products) { product ->
            ProductCard(product, onClick = onClickItem)
        }
    }
}

@Composable
fun Home(onProductClick: () -> Unit) {
    var searchInput by remember { mutableStateOf("") }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.ShoppingCart, null)
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).padding(8.dp, 8.dp, 8.dp, 0.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                )
                Spacer(Modifier.width(8.dp))
                OutlinedTextField(
                    value = searchInput,
                    onValueChange = { searchInput = it},
                    trailingIcon = { Icon(Icons.Filled.Search, null)},
                    placeholder = { Text("Type for search") },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            ProductList(
                products = listOf(
                    Product("Balon", "Lietajuci lahky plast", 0.19),
                    Product("Balon", "Lietajuci lahky plast", 0.19),
                ),
                onClickItem = onProductClick
            )
        }
    }
}
