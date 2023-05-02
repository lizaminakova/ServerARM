package com.example.demo.service.impl

import com.example.demo.entities.Products
import com.example.demo.entities.Request
import com.example.demo.repository.RequestRepository
import com.example.demo.service.RequestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RequestServiceImpl: RequestService {

    @Autowired
    lateinit var requestRepository: RequestRepository
    override fun addRequest(request: Request): Request {
        var savedRequest: Request = requestRepository.saveAndFlush(request)
        return savedRequest
    }

    override fun deleteRequest(id: Int) {
        requestRepository.deleteById(id)
    }

    override fun editRequest(request: Request): Request {
        return requestRepository.saveAndFlush(request)
    }

    override fun getAllRequest(request: ArrayList<Request>): List<Request> {
        return requestRepository.findAll()
    }
}