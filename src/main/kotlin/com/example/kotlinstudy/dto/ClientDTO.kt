package com.example.kotlinstudy.dto

import com.example.kotlinstudy.model.Client

data class ClientDTO(
    val name: String,
    val email: String,
    val addresses: List<AddressDTO>? = null
) {

    fun toModel(): Client {
        val client = Client(
            name = this.name,
            email = this.email
        )
        return client
    }
}
