package com.example.demo.repository

import com.example.demo.entities.Products
import org.springframework.data.jpa.repository.JpaRepository

interface ProductsRepository: JpaRepository<Products, Int>