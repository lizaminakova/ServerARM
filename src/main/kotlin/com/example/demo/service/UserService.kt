package com.example.demo.service

import com.example.demo.entities.User

interface UserService {
    fun getAllUser(user: ArrayList<User>): List<User>

    fun findByLogin(login: String?): User?
    fun login()
    fun register(user: User)
    fun forgotPassword()
}