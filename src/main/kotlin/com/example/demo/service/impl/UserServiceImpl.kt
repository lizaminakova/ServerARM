package com.example.demo.service.impl

import com.example.demo.entities.User
import com.example.demo.exceptions.MyException
import com.example.demo.repository.UserRepository
import com.example.demo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserServiceImpl: UserService {


    @Autowired
    lateinit var userRepository: UserRepository
    lateinit var mailSender: JavaMailSender
    override fun getAllUser(user: ArrayList<User>): List<User> {
        return userRepository.findAll()
    }
    @Throws(RuntimeException::class)
    override fun findByLogin(login: String?): User?  {
        return userRepository.findUserByLogin(login)
    }
    override fun register(user: User) {
        if (findByLogin(user.login) == null) {
            userRepository.saveAndFlush(user)
        }
        else {
            throw MyException("Пользователь с таким логином уже существует")
        }
    }
    override fun login(login: String, password: String): Int {
        var currentUser = userRepository.findUserByLogin(login)
        if (currentUser == null) {
            String.format("Пользователь с таким логином не найден:", login)
            throw UsernameNotFoundException(login)
        }
        else {
            if (password.equals(currentUser.password) ) {
                return currentUser.id
            }
            else {
                String.format("Неверный пароль")
                throw UsernameNotFoundException(password)
            }
        }
        return -1
    }
    override fun forgotPassword(login: String) {
        var currentUser = userRepository.findUserByLogin(login)
        if (currentUser == null) {
            String.format("Пользователь с таким логином не найден: ", login)
            throw UsernameNotFoundException(login)
        }
        else {
            val toAddress = currentUser.login
            val password = currentUser.password
            val fromAddress = "lizka"
            val senderName = ""
            val subject = "Пароль"
            var content =
                "Уважаемый [[name]],<br>" + "Ваш пароль:<br>" + "<h3>[[password]]</h3>" + "Благодарим за использование сервиса,<br>" + "."
            val message = mailSender.createMimeMessage()
            val helper = MimeMessageHelper(message)
            helper.setFrom(fromAddress, senderName)
            helper.setTo(toAddress!!)
            helper.setSubject(subject)
            content = content.replace("[[name]]", currentUser.userName!!)
            content = content.replace("[[password]]", currentUser.password!!)
            helper.setText(content, true)
            mailSender.send(message)

        }

    }
}
