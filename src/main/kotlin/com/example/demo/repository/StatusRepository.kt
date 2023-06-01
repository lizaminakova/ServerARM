package com.example.demo.repository

import com.example.demo.model.Status
import org.springframework.data.jpa.repository.JpaRepository

interface StatusRepository: JpaRepository<Status, Int>