package com.example.demo.service.impl

import com.example.demo.model.Request
import com.example.demo.model.User
import com.example.demo.repository.RequestRepository
import com.example.demo.repository.UserRepository
import com.example.demo.service.RequestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AnonymousAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service


@Service
class RequestServiceImpl : RequestService {

    @Autowired
    lateinit var requestRepository: RequestRepository

    @Autowired
    lateinit var userRepository: UserRepository

    fun getUser(): User? {
        val authentication = SecurityContextHolder.getContext().authentication
        if (authentication !is AnonymousAuthenticationToken) {
            val userPrincipal = authentication.principal as UserDetails
            println("User principal name =" + userPrincipal.username)
            println("Is user enabled =" + userPrincipal.isEnabled)
        }

        val userPrincipal = authentication.principal as UserDetails
        return userRepository.findUserByEmail(userPrincipal.username).get()
    }

    override fun addRequest(request: Request): Request {
        val user = getUser()
        request.user = user
        val savedRequest: Request = requestRepository.saveAndFlush(request)
        return savedRequest
    }

    override fun deleteRequest(id: Int) {
        requestRepository.deleteById(id)
    }

    //@PreFilter("filterObject.userId == authentication.name")
    override fun editRequest(request: Request): Request {


        val existingRequest = requestRepository.findById(request.id!!)
        if (existingRequest.isPresent) {
            val updatedRequest = existingRequest.get()
            updatedRequest.requestNumber = request.requestNumber
            updatedRequest.requestName = request.requestName
            updatedRequest.creationDate = request.creationDate
            updatedRequest.customer = request.customer
            updatedRequest.expectedDate = request.expectedDate
            updatedRequest.actualDate = request.actualDate
            updatedRequest.user = getUser()
            updatedRequest.status = request.status
            return requestRepository.saveAndFlush(updatedRequest)
        } else {
            throw RuntimeException("Request with id ${request.id} not found")
        }
    }

    //@PostFilter("filterObject.ownerId == authentication.name")
    override fun getAllRequest(): List<Request> {


        return requestRepository.findAllByUserId(getUser()?.id)
    }
}