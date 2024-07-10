package com.example.kotlinstudy.service

import com.example.kotlinstudy.dto.CustomerDTO
import com.example.kotlinstudy.model.Customer
import com.example.kotlinstudy.repository.CustomerRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.Optional

@Transactional
@Service
class CustomerService(
    val customerRepository: CustomerRepository
) {


    fun saveCustomer(customerDTO: CustomerDTO): Customer {

        val customerExist: Optional<Customer> = customerRepository.findByEmail(customerDTO.email)
        if(customerExist.isPresent){
            throw IllegalStateException("Email already in use")
        }
        return customerRepository.save(customerDTO.toModel())
    }

}