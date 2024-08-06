package com.example.kotlinstudy.model

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import java.math.BigInteger
import java.time.LocalDate

@Entity
@DiscriminatorValue("EMPLOYEE")
class Employee(
    name: String,
    email: String,
    var salary: BigInteger,
    var hireDate: LocalDate

): Person(
    name = name,
    email = email
)