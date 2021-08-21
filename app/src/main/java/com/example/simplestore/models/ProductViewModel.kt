package com.example.simplestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simplestore.data.productList

class ProductViewModel: ViewModel() {
    private val _products = MutableLiveData(productList())
    val products: LiveData<List<Product>> = _products

    fun getProductById(id: Int): Product? = _products.value?.find {
        it.id == id
    }
}