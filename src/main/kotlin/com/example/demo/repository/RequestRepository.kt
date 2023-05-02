package com.example.demo.repository

import com.example.demo.entities.Request
import org.springframework.data.jpa.repository.JpaRepository

interface RequestRepository: JpaRepository<Request, Int>