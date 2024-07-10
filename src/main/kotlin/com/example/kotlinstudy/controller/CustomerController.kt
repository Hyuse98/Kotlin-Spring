package com.example.kotlinstudy.controller

import com.example.kotlinstudy.dto.CustomerDTO
import com.example.kotlinstudy.model.Customer
import com.example.kotlinstudy.repository.CustomerRepository
import com.example.kotlinstudy.service.CustomerService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("/customer")
class CustomerController(val customerRepository: CustomerRepository, val customerService: CustomerService) {

    @GetMapping("/{id}")
    fun findById(@PathVariable @Valid id: UUID): ResponseEntity<Customer> {

        val customer: Customer =
            customerRepository.findById(id).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not Found") }
        return ResponseEntity.ok(customer)
    }

    @GetMapping
    fun listCustomers(): List<Customer> {
        return customerRepository.findAll()
    }

    @PostMapping
    fun createCustomer(@RequestBody @Valid customerDTO: CustomerDTO): ResponseEntity<Customer> {

        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.saveCustomer(customerDTO))
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: UUID) {
        customerRepository.deleteById(id)
    }

    @PutMapping("/{id}")
    fun updateCustomer(@PathVariable id: UUID, @RequestBody customerDTO: CustomerDTO): ResponseEntity<Customer> {
        if (!customerRepository.existsById(id)) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not Found")
        }
        val customer = customerDTO.toModel().apply { this.id = id }
        return ResponseEntity.status(HttpStatus.OK).body(customerRepository.save(customer))
    }
}