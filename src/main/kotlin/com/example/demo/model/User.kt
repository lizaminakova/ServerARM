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
    var id: Int?=null,

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "username")
    var username: String?,

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "email")
    var email: String?,

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "password")
    var password: String?

)