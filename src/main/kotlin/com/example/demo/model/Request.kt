package com.example.demo.model

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name = "request")
class Request (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: Int,

    @JdbcTypeCode(SqlTypes.INTEGER)
    @Column(name = "request_number")
    var requestNumber: Int,

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "request_name")
    var requestName: String?,

    @JdbcTypeCode(SqlTypes.DATE)
    @Column(name = "creation_date", length = 10)
    var creationDate: String?,

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "customer", length = 100)
    var customer: String?,

    @JdbcTypeCode(SqlTypes.DATE)
    @Column(name = "expected_date", length = 10)
    var expectedDate: String?,

    @JdbcTypeCode(SqlTypes.DATE)
    @Column(name = "actual_date", length = 10)
    var actualDate: String?,

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User?,

    @ManyToOne
    @JoinColumn(name = "status_id")
    var status: Status?,

    )