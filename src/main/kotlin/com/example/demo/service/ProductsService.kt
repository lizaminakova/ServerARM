package com.example.demo.service

import com.example.demo.entities.Products

interface ProductsService {
    fun addProducts(products: Products): Products
    fun deleteProducts(id: Int)
    fun editProducts(products: Products): Products
    fun getAllProducts(products: ArrayList<Products>): List<Products>
}