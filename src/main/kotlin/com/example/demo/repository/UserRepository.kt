package com.example.demo.repository

import com.example.demo.model.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository: JpaRepository<User, Int> {
    fun findUserByEmail(email: String?): Optional<User>

    fun findUserById(id: Long): User

}