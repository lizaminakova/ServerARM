package com.example.demo.model.dto.user

import org.jetbrains.annotations.NotNull

class RegisterRequest {
    @NotNull
    lateinit var email: String
    @NotNull
    lateinit var username: String
    @NotNull
    lateinit var password: String

}