package com.example.kotlinstudy.repository

import com.example.kotlinstudy.model.Customer
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CustomerRepository : JpaRepository<Customer, UUID> {

    fun findByEmail(email: String): Optional<Customer>

}