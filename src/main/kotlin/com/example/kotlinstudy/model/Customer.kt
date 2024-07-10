package com.example.kotlinstudy.model

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import java.time.LocalDate

@Entity
@DiscriminatorValue("CUSTOMER")
class Customer(
    name: String,
    email: String,
    var birthDate: LocalDate
) : Person()