package com.example.demo.controller.product

import com.example.demo.model.Products
import com.example.demo.service.ProductsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("products")
class ProductsController constructor(
    @Autowired
    private val productsService: ProductsService
) {
    @PostMapping("/add")
    fun addProducts(@RequestBody products: Products) {
        productsService.addProducts(products)
    }

    @DeleteMapping("/{id}")
    fun deleteProducts(@PathVariable(value = "id") id: Int) {
        productsService.deleteProducts(id)
    }

    @PostMapping("/edit")
    fun editProducts(@RequestBody products: Products) {
        productsService.editProducts(products)
    }

    @GetMapping("/all")
    fun getAllProducts() {
        productsService.getAllProducts()
    }

}