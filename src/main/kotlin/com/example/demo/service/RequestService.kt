package com.example.demo.service

import com.example.demo.model.Request


interface RequestService {
    fun addRequest(request: Request): Request
    fun deleteRequest(id: Int)
    fun editRequest(request: Request): Request
    fun getAllRequest(): List<Request>
}