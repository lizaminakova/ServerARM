package com.example.demo.repository

import com.example.demo.model.Request
import com.example.demo.model.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface RequestRepository: JpaRepository<Request, Int>{
    fun findAllByUserId(userId: Int?): List<Request>
}
