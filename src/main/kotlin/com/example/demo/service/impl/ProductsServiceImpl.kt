package com.example.demo.service.impl

import com.example.demo.model.Products
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
        val existingProduct = productRepository.findById(products.id!!)
        if (existingProduct.isPresent) {
            val updatedProduct = existingProduct.get()
            updatedProduct.productName = products.productName
            return productRepository.saveAndFlush(updatedProduct)
        } else {
            throw RuntimeException("Product with id ${products.id} not found")
        }
    }

    override fun getAllProducts(): List<Products> {
        return productRepository.findAll()
    }


}