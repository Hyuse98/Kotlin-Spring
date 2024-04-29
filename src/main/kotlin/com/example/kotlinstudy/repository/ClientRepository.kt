package com.example.kotlinstudy.repository

import com.example.kotlinstudy.model.Client
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ClientRepository : JpaRepository<Client, UUID> {

    fun findByEmail(email: String): Optional<Client>
}