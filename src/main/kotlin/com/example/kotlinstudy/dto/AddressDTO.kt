package com.example.kotlinstudy.dto

import com.example.kotlinstudy.model.Address
import java.util.*

data class AddressDTO(
    val city: String,
    val client_id: UUID
) {
    fun toModel(): Address {
        return Address(
            city = this.city,
            client_id = this.client_id
        )

    }
}
