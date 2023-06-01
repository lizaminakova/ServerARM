package com.example.demo.model

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name = "user")
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: Int,

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "user_name")
    var userName: String?,

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "login")
    var login: String?,

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "password")
    var password: String?

)