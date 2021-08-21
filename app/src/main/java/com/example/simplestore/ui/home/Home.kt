package com.example.simplestore.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.simplestore.R
import com.example.simplestore.data.productList
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
    val homeViewModel: HomeViewModel = viewModel()
    val focusManager = LocalFocusManager.current

    val searchInput by homeViewModel.searchInput.observeAsState("")

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.ShoppingCart, null)
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(8.dp, 8.dp, 8.dp, 0.dp)
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
                    onValueChange = homeViewModel::setSearchInput,
                    trailingIcon = { Icon(Icons.Filled.Search, null)},
                    placeholder = { Text("Type for search") },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(onSearch = {
                        focusManager.clearFocus()
                    }),
                    shape = RoundedCornerShape(35),
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            ProductList(
                products = productList(),
                onClickItem = onProductClick
            )
        }
    }
}
