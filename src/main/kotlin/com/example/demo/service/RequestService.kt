package com.example.demo.service

import com.example.demo.entities.Request


interface RequestService {
    fun addRequest(request: Request): Request
    fun deleteRequest(id: Int)
    fun editRequest(request: Request): Request
    fun getAllRequest(request: ArrayList<Request>): List<Request>
}