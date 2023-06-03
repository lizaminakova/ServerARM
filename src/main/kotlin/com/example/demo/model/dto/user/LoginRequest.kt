package com.example.demo.model.dto.user

import lombok.Data
import org.jetbrains.annotations.NotNull

@Data
class LoginRequest {

    @NotNull
    lateinit var email: String

    @NotNull
    lateinit var password: String
}