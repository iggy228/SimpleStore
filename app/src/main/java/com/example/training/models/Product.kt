package com.example.training.models

data class Product(
    var name: String,
    var shortDescription: String,
    var price: Double,
    var liked: Boolean = false,
)
