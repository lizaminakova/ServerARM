package com.example.demo.controller.user

import com.example.demo.controller.ResponseMessage
import com.example.demo.model.User
import com.example.demo.model.dto.user.LoginRequest
import com.example.demo.model.dto.user.RegisterRequest
import com.example.demo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.UnsupportedEncodingException

@RestController
@RequestMapping(path=["/users"])
class UserController(
    @Autowired
    private val userService: UserService
) {


    @PostMapping("/register")
    @Throws(UnsupportedEncodingException::class)
    fun register(@RequestBody request: RegisterRequest) {
        userService.register(User(null,request.username, request.email, request.password))
    }

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<*> {
        val login = request.email
        val password = request.password

        val success = userService.login(login, password)
            ?: return ResponseEntity(ResponseMessage("User not exist"),HttpStatus.UNAUTHORIZED)

        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, success.accessToken).body("")

    }

    @PostMapping("/forgotPassword")
    fun forgotPassword(@RequestBody login: String) {
        userService.forgotPassword(login)
    }

}