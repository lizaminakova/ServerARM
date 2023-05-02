package com.example.demo.service

import com.example.demo.entities.Status

interface StatusService {
    fun addStatus(status: Status): Status
    fun deleteProducts(id: Int)
    fun editProducts(status: Status): Status
    fun getAllProducts(status: ArrayList<Status>): List<Status>
}