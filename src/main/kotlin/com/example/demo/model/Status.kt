package com.example.demo.model

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name = "status")
class Status (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: Int,

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "status_name", length = 10)
    var statusName: String?
)