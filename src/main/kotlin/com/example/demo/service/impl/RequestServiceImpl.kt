package com.example.demo.service.impl

import com.example.demo.model.Request
import com.example.demo.repository.RequestRepository
import com.example.demo.service.RequestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PostFilter
import org.springframework.security.access.prepost.PreFilter
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

    @PreFilter("filterObject.userId == authentication.name")
    override fun editRequest(request: Request): Request {
        return requestRepository.saveAndFlush(request)
    }

    @PostFilter("filterObject.ownerId == authentication.name")
    override fun getAllRequest(): List<Request> {
        return requestRepository.findAll()
    }
}