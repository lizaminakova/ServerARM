package com.example.demo.security

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtTokenFilter(
    private val jwtTokenUtil: JwtTokenUtil,
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val authorizationHeader: String = request.getHeader("Authorization") ?: return filterChain.doFilter(request, response)
        val token = authorizationHeader.substring("Bearer ".length) ?: return filterChain.doFilter(request, response)

        if (jwtTokenUtil.validate(token)) {
            val id = jwtTokenUtil.getUserId(token)
            val authentication: Authentication = jwtTokenUtil.getAuthentication(id)
            SecurityContextHolder.getContext().authentication = authentication
        }

        filterChain.doFilter(request, response)
    }
}
