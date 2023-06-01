package com.example.demo.service

import com.example.demo.model.Products

interface ProductsService {

    fun addProducts(products: Products): Products
    fun deleteProducts(id: Int)
    fun editProducts(products: Products): Products
    fun getAllProducts(): List<Products>
}