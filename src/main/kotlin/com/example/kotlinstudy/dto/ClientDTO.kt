package com.example.kotlinstudy.dto

import com.example.kotlinstudy.model.Client

data class ClientDTO(
    val name: String,
    val email: String
) {

    fun toModel(): Client {
        return Client(
            name = this.name,
            email = this.email
        )
    }
}
