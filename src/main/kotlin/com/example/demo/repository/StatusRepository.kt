package com.example.demo.repository

import com.example.demo.entities.Status
import org.springframework.data.jpa.repository.JpaRepository

interface StatusRepository: JpaRepository<Status, Int>