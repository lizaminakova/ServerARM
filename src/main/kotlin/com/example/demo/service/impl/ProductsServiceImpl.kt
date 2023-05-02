package com.example.demo.service.impl

import com.example.demo.entities.Products
import com.example.demo.repository.ProductsRepository
import com.example.demo.service.ProductsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductsServiceImpl: ProductsService {

    @Autowired
    lateinit var productRepository: ProductsRepository
    override fun addProducts(products: Products): Products {
        var savedProduct: Products = productRepository.saveAndFlush(products)
        return savedProduct
    }

    override fun deleteProducts(id: Int) {
        productRepository.deleteById(id)
    }

    override fun editProducts(products: Products): Products {
        return productRepository.saveAndFlush(products)
    }

    override fun getAllProducts(products: ArrayList<Products>): List<Products> {
        return productRepository.findAll()
    }


}