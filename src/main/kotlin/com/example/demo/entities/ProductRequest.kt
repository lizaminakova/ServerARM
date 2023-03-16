package com.example.demo.entities

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name = "product_request")

class ProductRequest (
    @EmbeddedId
    var id: ProductRequestKey,

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    var product: Products?,

    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    var request: Request?,

    @JdbcTypeCode(SqlTypes.INTEGER)
    @Column(name = "amount")
    var amount: Int
)