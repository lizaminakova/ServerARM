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
            userRepository.findUserByEmail(s).orElseThrow { UsernameNotFoundException("The email $s doesn't exist") }

        val authorities = ArrayList<GrantedAuthority>()

        return User(
            user.email, user.password, authorities
        )
    }
}