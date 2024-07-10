package com.example.kotlinstudy.model

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import java.time.LocalDate

@Entity
@DiscriminatorValue("EMPLOYEE")
class Employee(
    var hireDate: LocalDate

): Person()