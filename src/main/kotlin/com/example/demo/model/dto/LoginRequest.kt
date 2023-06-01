package com.example.demo.model.dto

import lombok.Data
import org.jetbrains.annotations.NotNull

@Data
class LoginRequest {

    @NotNull
    lateinit var login: String

    @NotNull
    lateinit var password: String
}