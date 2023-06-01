package com.example.demo.service.impl

import com.example.demo.repository.UserRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
class UserDetailsServiceImpl(private val userRepository: UserRepository) : UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(s: String): UserDetails {
        val user =
            userRepository.findUserByLogin(s).orElseThrow { UsernameNotFoundException("The username $s doesn't exist") }

        val authorities = ArrayList<GrantedAuthority>()

        return User(
            user.login, user.password, authorities
        )
    }
}