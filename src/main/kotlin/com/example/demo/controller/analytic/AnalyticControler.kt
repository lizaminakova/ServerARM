package com.example.demo.controller.analytic

import com.example.demo.service.ProductsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("analytics")
class AnalyticController(
    @Autowired
    private val productsService: ProductsService
) {
    @GetMapping("/all")
    fun getAnalytics() {
        productsService.getAllProducts()
    }

}