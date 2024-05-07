package com.example.kotlinstudy.dto

import com.example.kotlinstudy.model.Address
import com.example.kotlinstudy.model.Client
import java.util.*

data class AddressDTO(
    val city: String,
    val client: Client
) {
    fun toModel(): Address {
        return Address(
            city = this.city,
            client = this.client
        )

    }
}
