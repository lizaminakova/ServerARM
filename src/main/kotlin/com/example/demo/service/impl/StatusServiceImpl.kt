package com.example.demo.service.impl

import com.example.demo.entities.Products
import com.example.demo.entities.Status
import com.example.demo.repository.StatusRepository
import com.example.demo.service.StatusService
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired

@Service
class StatusServiceImpl: StatusService {

    @Autowired
    lateinit var statusRepository: StatusRepository
    override fun addStatus(status: Status): Status {
        var savedStatus: Status = statusRepository.saveAndFlush(status)
        return savedStatus
    }

    override fun deleteProducts(id: Int) {
        statusRepository.deleteById(id)
    }

    override fun editProducts(status: Status): Status {
        return statusRepository.saveAndFlush(status)
    }

    override fun getAllProducts(status: ArrayList<Status>): List<Status> {
        return statusRepository.findAll()
    }
}