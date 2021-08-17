package com.example.training.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import com.example.training.R
import com.example.training.models.Product

@Composable
fun ProductList(products: List<Product>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(products) { product ->
            ProductCard(product, onClick = {})
        }
    }
}

@Composable
fun Home() {
    var searchInput by remember { mutableStateOf("") }

    Column {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = null,
                modifier = Modifier
                    .aspectRatio(1f)
                    .fillMaxHeight()
                    .clip(CircleShape)
            )
            OutlinedTextField(
                value = searchInput,
                onValueChange = { searchInput = it},
                trailingIcon = {
                    Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = null)
                },
                modifier = Modifier.fillMaxWidth(),
            )
        }
        ProductList(products = listOf(
            Product("Balon", "Lietajuci lahky plast",0.19),
            Product("Balon", "Lietajuci lahky plast", 0.19),
        ))
    }
}
