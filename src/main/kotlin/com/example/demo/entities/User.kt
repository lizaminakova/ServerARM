package com.example.demo.entities

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name = "user")
open class User (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "user_name")
    var userName: String? = null,

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "login")
    var login: String? = null,

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "password")
    var password: String? = null

)