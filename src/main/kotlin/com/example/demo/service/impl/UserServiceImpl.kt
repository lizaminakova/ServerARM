package com.example.demo.service.impl

import com.example.demo.entities.Status
import com.example.demo.entities.User
import com.example.demo.repository.UserRepository
import com.example.demo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl: UserService {


    @Autowired
    lateinit var userRepository: UserRepository
    override fun getAllUser(user: ArrayList<User>): List<User> {
        return userRepository.findAll()
    }

    override fun findByLogin(login: String?): User? {
        return userRepository.findUserByLogin(login)
    }
    override fun register(user: User) {
        if (findByLogin(user.login) == null) {
            userRepository.saveAndFlush(user)
        }
        else {

        }
    }
    override fun login() {
        TODO("Not yet implemented")
    }
    override fun forgotPassword() {
        TODO("Not yet implemented")
    }
}
