package com.example.demo.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable


@Embeddable
class ProductRequestKey (
    @Column(name = "product_id")
    var productId: Int,

    @Column(name = "request_id")
    var requestId: Int
): Serializable