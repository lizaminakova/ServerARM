package com.example.demo.service.impl

import com.example.demo.controller.JwtResponse
import com.example.demo.exceptions.MyException
import com.example.demo.model.User
import com.example.demo.repository.UserRepository
import com.example.demo.security.JwtTokenUtil
import com.example.demo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl : UserService {

    @Autowired
    lateinit var authenticationManager: AuthenticationManager

    @Autowired
    lateinit var jwtTokenUtil: JwtTokenUtil
    @Autowired
    lateinit var passwordEncoder: PasswordEncoder
    @Autowired
    lateinit var userRepository: UserRepository
    lateinit var mailSender: JavaMailSender
    override fun getAllUser(): List<User> {
        return userRepository.findAll()
    }

    @Throws(RuntimeException::class)
    override fun findByEmail(email: String?): Optional<User> {
        return userRepository.findUserByEmail(email)
    }

    override fun register(user: User) {
        if (findByEmail(user.email).isEmpty) {
            user.password = passwordEncoder.encode(user.password)
            userRepository.saveAndFlush(user)
        } else {
            throw MyException("Пользователь с такой электронной почтой уже существует")
        }
    }

    override fun login(email: String, password: String): JwtResponse? {
        val userCandidate: Optional<User> = userRepository.findUserByEmail(email)

        if (userCandidate.isPresent) {
            val user: User = userCandidate.get()
            val authentication = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(email, password)
            )
            SecurityContextHolder.getContext().authentication = authentication
            val jwt: String = jwtTokenUtil.generateAccessToken(user)
            val authorities: List<GrantedAuthority> = ArrayList()
            return JwtResponse(jwt, email, authorities)
        } else {
            return null
        }
    }

    override fun forgotPassword(email: String) {
//        var currentUser = userRepository.findUserByLogin(login)
//        if (currentUser == null) {
//            String.format("Пользователь с таким логином не найден: ", login)
//            throw UsernameNotFoundException(login)
//        } else {
//            val toAddress = currentUser.login
//            val password = currentUser.password
//            val fromAddress = "lizka"
//            val senderName = ""
//            val subject = "Пароль"
//            var content =
//                "Уважаемый [[name]],<br>" + "Ваш пароль:<br>" + "<h3>[[password]]</h3>" + "Благодарим за использование сервиса,<br>" + "."
//            val message = mailSender.createMimeMessage()
//            val helper = MimeMessageHelper(message)
//            helper.setFrom(fromAddress, senderName)
//            helper.setTo(toAddress!!)
//            helper.setSubject(subject)
//            content = content.replace("[[name]]", currentUser.userName!!)
//            content = content.replace("[[password]]", currentUser.password!!)
//            helper.setText(content, true)
//            mailSender.send(message)

        //      }

    }
}
