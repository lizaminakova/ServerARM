package com.example.demo.service

import com.example.demo.controller.JwtResponse
import com.example.demo.model.Request
import com.example.demo.model.User
import java.util.*

interface UserService {
    fun getAllUser(): List<User>
    @Throws(RuntimeException::class)
    fun findByEmail(email: String?): Optional<User>
    fun login(email: String, password: String) : JwtResponse?

    fun register(user: User)

    fun forgotPassword(email: String)

}