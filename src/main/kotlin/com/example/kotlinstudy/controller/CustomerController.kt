package com.example.kotlinstudy.controller

import com.example.kotlinstudy.dto.CustomerDTO
import com.example.kotlinstudy.model.Customer
import com.example.kotlinstudy.model.Person
import com.example.kotlinstudy.repository.PersonRepository
import com.example.kotlinstudy.service.CustomerService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("/customer")
class CustomerController(val personRepository: PersonRepository, val customerService: CustomerService) {

    @GetMapping("/{id}")
    fun findById(@PathVariable @Valid id: UUID): ResponseEntity<Person> {

        val customer: Person =
            personRepository.findById(id)
                .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not Found") }
        return ResponseEntity.ok(customer)
    }

    @GetMapping
    fun listCustomers(): List<Person> {
        return personRepository.findAll()
    }

    @PostMapping
    fun createCustomer(@RequestBody @Valid customerDTO: CustomerDTO): ResponseEntity<Customer> {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.saveCustomer(customerDTO))
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: UUID) {
        personRepository.deleteById(id)
    }

    @PutMapping("/{id}")
    fun updateCustomer(@PathVariable id: UUID, @RequestBody customerDTO: CustomerDTO): ResponseEntity<Customer> {
        if (!personRepository.existsById(id)) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not Found")
        }
        val customer = customerDTO.toModel().apply { this.id = id }
        return ResponseEntity.status(HttpStatus.OK).body(personRepository.save(customer))
    }
}