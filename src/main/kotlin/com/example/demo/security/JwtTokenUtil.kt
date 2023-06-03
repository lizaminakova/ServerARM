package com.example.demo.security

import com.example.demo.model.User
import com.example.demo.service.impl.UserDetailsServiceImpl
import io.jsonwebtoken.*
import io.jsonwebtoken.security.Keys
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.lang.String.format
import java.nio.charset.StandardCharsets
import java.security.Key
import java.util.*

@Component
@RequiredArgsConstructor
class JwtTokenUtil(private val userDetailsService: UserDetailsServiceImpl) {
    private val jwtIssuer = "mosit"

    @Value("\${jwt.token.secret}")
    private val jwtSecret: String? = null
    private val signingKey: Key
        private get() {
            val keyBytes = jwtSecret!!.toByteArray(StandardCharsets.UTF_8)
            return Keys.hmacShaKeyFor(keyBytes)
        }

    fun generateAccessToken(user: User): String {
        return Jwts.builder().setSubject(format("%s,%s", user.id, user.email)).setIssuer(jwtIssuer).setIssuedAt(
            Date()
        ).setExpiration(Date(System.currentTimeMillis() + 2 * 24 * 60 * 60 * 1000)) // 2 days
            .signWith(signingKey).compact()
    }

    fun getUserId(token: String): String {
        var token = token
        if (token.contains("Bearer")) token = token.replace("Bearer", "").strip()
        val claims: Claims = Jwts.parserBuilder().setSigningKey(signingKey).build().parseClaimsJws(token).body
        return claims.subject.split(",").get(0)
    }

    fun getUsername(token: String): String {
        var token = token
        if (token.contains("Bearer")) token = token.replace("Bearer", "").strip()
        val claims: Claims = Jwts.parserBuilder().setSigningKey(signingKey).build().parseClaimsJws(token).body
        return claims.subject.split(",").get(1)
    }

    fun getExpirationDate(token: String?): Date {
        val claims: Claims = Jwts.parserBuilder().setSigningKey(signingKey).build().parseClaimsJws(token).body
        return claims.expiration
    }

    fun getAuthentication(id: String): Authentication {
        val userDetails: UserDetails = userDetailsService.loadUserByUsername(id)

        return UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
    }

    fun validate(token: String?): Boolean {
        try {
            Jwts.parserBuilder().setSigningKey(signingKey).build().parseClaimsJws(token)
            return true
        } catch (ex: MalformedJwtException) {
        } catch (ex: ExpiredJwtException) {
        } catch (ex: UnsupportedJwtException) {
        } catch (ex: IllegalArgumentException) {
        }
        return false
    }
}
