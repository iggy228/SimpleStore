package com.example.training.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.training.R
import com.example.training.models.Product

@Composable
fun ProductCard(product: Product, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_shopping_cart),
            contentDescription = null,
            modifier = Modifier.size(120.dp),
        )
        Column {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    product.name,
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.fillMaxWidth()
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_star_border),
                    contentDescription = null,
                    modifier = Modifier.fillMaxHeight(),
                )
            }
            Text(
                product.shortDescription,
                style = MaterialTheme.typography.body1,
            )
            Text(
                "${product.price} €",
                style = MaterialTheme.typography.body2,
            )
        }
    }
}