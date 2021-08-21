package com.example.simplestore.data

import com.example.simplestore.models.Product

fun productList(): List<Product> {
    return listOf(
        Product(1, "balon", "lietajuci plat", 0.19f, 10, null),
        Product(2, "baalon", "lietajuci plat", 0.19f, 10, null),
        Product(3, "ballon", "lietajuci plat", 0.19f, 10, null),
        Product(4, "baloon", "lietajuci plat", 0.19f, 10, null),
    )
}