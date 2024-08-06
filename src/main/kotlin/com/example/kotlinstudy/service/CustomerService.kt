package com.example.kotlinstudy.service

import com.example.kotlinstudy.dto.CustomerDTO
import com.example.kotlinstudy.model.Customer
import com.example.kotlinstudy.repository.PersonRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Transactional
@Service
class CustomerService(
    val personRepository: PersonRepository
) {


    fun saveCustomer(customerDTO: CustomerDTO): Customer {

        val customerExist = personRepository.findByEmail(customerDTO.email)
        if (customerExist.isPresent) {
            throw IllegalStateException("Email already in use")
        }
        return personRepository.save(customerDTO.toModel())
    }

}