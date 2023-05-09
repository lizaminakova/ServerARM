package com.example.demo.service

import com.example.demo.entities.User
import java.io.UnsupportedEncodingException

interface UserService {
    fun getAllUser(user: ArrayList<User>): List<User>
    @Throws(RuntimeException::class)
    fun findByLogin(login: String?): User?
    fun login(login: String, password: String) : Int

    fun register(user: User)

    fun forgotPassword(login: String)
}