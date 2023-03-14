package com.example.demo.entities

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name = "request")
open class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Int? = null

    @JdbcTypeCode(SqlTypes.INTEGER)
    @Column(name = "request_number")
    open var requestNumber: String? = null

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "request_name")
    open var requestName: String? = null

    @JdbcTypeCode(SqlTypes.DATE)
    @Column(name = "creation_date", length = 10)
    open var creationDate: String? = null

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "customer", length = 100)
    open var customer: String? = null

    @JdbcTypeCode(SqlTypes.DATE)
    @Column(name = "expected_date", length = 10)
    open var expectedDate: String? = null

    @JdbcTypeCode(SqlTypes.DATE)
    @Column(name = "actual_date", length = 10)
    open var actualDate: String? = null

    @ManyToOne
    @JoinColumn(name = "user_id")
    open var user: User? = null

    @ManyToOne
    @JoinColumn(name = "status_id")
    open var status: Status? = null
}