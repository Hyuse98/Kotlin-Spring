package com.example.kotlinstudy.controller

import com.example.kotlinstudy.dto.AddressDTO
import com.example.kotlinstudy.model.Address
import com.example.kotlinstudy.repository.AddressRepository
import com.example.kotlinstudy.repository.PersonRepository
import com.example.kotlinstudy.service.AddressService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("/address")
class AddressController(
    val addressService: AddressService,
    val addressRepository: AddressRepository,
    val personRepository: PersonRepository
) {

    @GetMapping
    fun findAll(): List<Address> {
        return addressRepository.findAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): ResponseEntity<Address> {

        var address: Optional<Address> = addressRepository.findById(id)
        if (address.isPresent) {
            return ResponseEntity.ok(address.get())
        }
        return throw ResponseStatusException(HttpStatus.NOT_FOUND, "Address not Found")
    }

    @PostMapping
    fun create(@RequestBody addressDTO: AddressDTO): ResponseEntity<Address> {

        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.createAddress(addressDTO))
    }

//    @DeleteMapping
//    fun delete() {
//
//    }
//
//    @PutMapping
//    fun update(): ResponseEntity<Address> {
//
//    }
}