package com.example.demo.entities

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name = "status")
open class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Int? = null

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "status_name", length = 10)
    open var statusName: String? = null
}