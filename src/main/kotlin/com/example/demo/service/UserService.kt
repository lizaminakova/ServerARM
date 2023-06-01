package com.example.demo.service

import com.example.demo.controller.JwtResponse
import com.example.demo.model.User

interface UserService {
    fun getAllUser(user: ArrayList<User>): List<User>
    @Throws(RuntimeException::class)
    fun findByLogin(login: String?): User?
    fun login(login: String, password: String) : JwtResponse?

    fun register(user: User)

    fun forgotPassword(login: String)
}