package com.example.kotlinstudy.dto

import com.example.kotlinstudy.model.Customer
import java.time.LocalDate

data class CustomerDTO(
    val name: String,
    val email: String,
    val birthDate: LocalDate,
    val addresses: List<AddressDTO>? = null
) {

    fun toModel(): Customer {
        val customer = Customer(
            name = this.name,
            email = this.email,
            birthDate = this.birthDate
        )
        return customer
    }
}
