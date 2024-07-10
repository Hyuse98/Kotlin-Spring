package com.example.kotlinstudy.dto

import com.example.kotlinstudy.model.Address
import java.util.*

data class AddressDTO(
    val city: String,
    val personId: UUID
) {
    fun toModel(): Address {
        return Address(
            city = this.city,
            personId = this.personId
        )

    }
}
