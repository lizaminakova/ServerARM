package com.example.demo.entities

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name = "request")
open class Request (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    @JdbcTypeCode(SqlTypes.INTEGER)
    @Column(name = "request_number")
    var requestNumber: String? = null,

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "request_name")
    var requestName: String? = null,

    @JdbcTypeCode(SqlTypes.DATE)
    @Column(name = "creation_date", length = 10)
    var creationDate: String? = null,

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "customer", length = 100)
    var customer: String? = null,

    @JdbcTypeCode(SqlTypes.DATE)
    @Column(name = "expected_date", length = 10)
    var expectedDate: String? = null,

    @JdbcTypeCode(SqlTypes.DATE)
    @Column(name = "actual_date", length = 10)
    var actualDate: String? = null,

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User? = null,

    @ManyToOne
    @JoinColumn(name = "status_id")
    var status: Status? = null,

    @JoinTable
    @OneToMany
    val products: Set<Products>
)