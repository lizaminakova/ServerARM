package com.example.demo.model

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name = "product_request")

class ProductRequest (
    @EmbeddedId
    var id: ProductRequestKey,


    @ManyToOne
    //@JoinColumn(name = "product_id", nullable = false)
    @JoinColumn(insertable=false, updatable=false)
    var product: Products?,

    @ManyToOne
    //@JoinColumn(name = "request_id", nullable = false)
    @JoinColumn(insertable=false, updatable=false)
    var request: Request?,

    @JdbcTypeCode(SqlTypes.INTEGER)
    @Column(name = "amount")
    var amount: Int
)