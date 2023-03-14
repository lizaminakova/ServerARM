package com.example.demo.entities

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name = "products")
open class Products (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "product_name")
    var productName: String? = null
)