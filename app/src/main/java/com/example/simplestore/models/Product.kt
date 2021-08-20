package com.example.simplestore.models

/**
 * Data class product that will be globally use in app.
 *
 * @param fullDescription is not required and it will be use shortDescription
 * @param weight must be in gram.
 */
data class Product(
    val id: Int,
    var name: String,
    var shortDescription: String,
    var price: Float,
    var weight: Int,
    var fullDescription: String? = null,
    var liked: Boolean = false,
)
