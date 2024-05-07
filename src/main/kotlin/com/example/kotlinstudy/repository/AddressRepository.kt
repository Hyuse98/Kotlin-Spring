package com.example.kotlinstudy.repository;

import com.example.kotlinstudy.model.Address
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface AddressRepository : JpaRepository<Address, UUID> {
}