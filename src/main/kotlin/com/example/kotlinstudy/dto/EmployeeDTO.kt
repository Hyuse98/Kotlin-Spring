package com.example.kotlinstudy.dto

import com.example.kotlinstudy.model.Employee
import java.math.BigInteger
import java.time.LocalDate

data class EmployeeDTO(
    val name: String,
    val email: String,
    val salary: BigInteger,
    val hireDate: LocalDate
) {
    fun toModel(): Employee {
        val employee = Employee(
            name = this.name,
            email = this.email,
            salary = this.salary,
            hireDate = this.hireDate
        )
        return employee
    }
}