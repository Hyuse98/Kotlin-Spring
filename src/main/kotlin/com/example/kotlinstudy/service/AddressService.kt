package com.example.kotlinstudy.service

import com.example.kotlinstudy.dto.AddressDTO
import com.example.kotlinstudy.model.Address
import com.example.kotlinstudy.repository.AddressRepository
import com.example.kotlinstudy.repository.CustomerRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
class AddressService(val customerRepository: CustomerRepository, val addressRepository: AddressRepository) {

    @Transactional
    fun createAddress(addressDTO: AddressDTO): Address {
        val customer = customerRepository.findById(addressDTO.personId)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not Found") }

        val address = addressDTO.toModel()
        return addressRepository.save(address)
    }
}