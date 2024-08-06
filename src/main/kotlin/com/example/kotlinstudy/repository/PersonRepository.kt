package com.example.kotlinstudy.repository

import com.example.kotlinstudy.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PersonRepository : JpaRepository<Person, UUID> {

    fun findByEmail(email: String): Optional<Person>

}