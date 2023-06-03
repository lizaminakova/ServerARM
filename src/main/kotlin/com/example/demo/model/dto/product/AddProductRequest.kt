package com.example.demo.model.dto.product

import lombok.Data
import org.jetbrains.annotations.NotNull

@Data
class AddProductRequest {
    @NotNull
    lateinit var productName: String
}