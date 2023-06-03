package com.example.demo.controller.product

import com.example.demo.model.Products
import com.example.demo.model.dto.product.AddProductRequest
import com.example.demo.service.ProductsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path=["/products"])
class ProductsController constructor(
    @Autowired
    private val productsService: ProductsService
) {
    @PostMapping("/add")
    fun addProducts(@RequestBody product: AddProductRequest) {
        productsService.addProducts(Products(null,product.productName))
    }

    @DeleteMapping("/{id}")
    fun deleteProducts(@PathVariable(value = "id") id: Int) {
        productsService.deleteProducts(id)
    }

    @PutMapping("/{id}")
    fun editProducts(@PathVariable(value = "id") id: Int, @RequestBody products: Products): Products {
        products.id = id
        return productsService.editProducts(products)
    }

    @GetMapping("/all")
    fun getAllProducts(): List<Products>{
        return productsService.getAllProducts()
    }

}