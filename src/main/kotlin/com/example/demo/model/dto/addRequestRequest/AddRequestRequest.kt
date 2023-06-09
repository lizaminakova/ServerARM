package com.example.demo.model.dto.addRequestRequest

import jakarta.persistence.Column
import lombok.Data
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import org.jetbrains.annotations.NotNull

@Data
class AddRequestRequest {
    @NotNull
    var requestNumber: Int = 0
    @NotNull
    lateinit var requestName: String
    @NotNull
    lateinit var creationDate: String
    @NotNull
    lateinit var customer: String
    @NotNull
    lateinit var expectedDate: String

    lateinit var actualDate: String
    @NotNull
    lateinit var status: String

}