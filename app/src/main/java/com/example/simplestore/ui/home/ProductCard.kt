package com.example.simplestore.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.simplestore.models.Product

@Composable
fun ProductCard(product: Product, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable(onClick = onClick)
    ) {
        Image(
            painter = rememberImagePainter("https://developer.android.com/images/brand/Android_Robot.png"),
            contentDescription = null,
            modifier = Modifier.size(100.dp).padding(8.dp),
        )
        Column {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    product.name,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth()
                )
                Icon(
                    Icons.Outlined.Star,
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
                style = MaterialTheme.typography.body1,
            )
        }
    }
}