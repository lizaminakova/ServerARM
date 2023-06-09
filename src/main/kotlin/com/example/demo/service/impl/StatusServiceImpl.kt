package com.example.demo.service.impl
//
//import com.example.demo.model.Status
//import com.example.demo.repository.StatusRepository
//import com.example.demo.service.StatusService
//import org.springframework.stereotype.Service
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.security.access.prepost.PostFilter
//
//@Service
//class StatusServiceImpl: StatusService {
//
//    @Autowired
//    lateinit var statusRepository: StatusRepository
//    override fun addStatus(status: Status): Status {
//        var savedStatus: Status = statusRepository.saveAndFlush(status)
//        return savedStatus
//    }
//
//    override fun deleteStatus(id: Int) {
//        statusRepository.deleteById(id)
//    }
//
//    override fun editStatus(status: Status): Status {
//        return statusRepository.saveAndFlush(status)
//    }
//    override fun getAllStatus(): List<Status> {
//        return statusRepository.findAll()
//    }
//}