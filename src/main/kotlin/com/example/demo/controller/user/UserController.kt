package com.example.demo.controller.user

import com.example.demo.controller.JwtResponse
import com.example.demo.controller.ResponseMessage
import com.example.demo.model.User
import com.example.demo.model.dto.LoginRequest
import com.example.demo.service.UserService
import org.apache.coyote.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.UnsupportedEncodingException

@RestController
@RequestMapping("users")
class UserController(
    @Autowired
    private val userService: UserService
) {


    @PostMapping("/register")
    @Throws(UnsupportedEncodingException::class)
    fun register(@RequestBody user: User) {
        userService.register(user)
    }

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<*> {
        val login = request.login
        val password = request.password

        if (login == null || password == null) {
            throw IllegalArgumentException("Login and password are required")
        }

        val success = userService.login(login, password)

        if (success == null)
            return ResponseEntity(ResponseMessage("User not exist"),HttpStatus.BAD_REQUEST)

        return ResponseEntity.ok(success)

    }

    @PostMapping("/forgotPassword")
    fun forgotPassword(@RequestBody login: String) {
        userService.forgotPassword(login)
    }

}