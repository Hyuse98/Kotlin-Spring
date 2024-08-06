package com.example.kotlinstudy.controller

import com.example.kotlinstudy.dto.EmployeeDTO
import com.example.kotlinstudy.model.Employee
import com.example.kotlinstudy.model.Person
import com.example.kotlinstudy.repository.PersonRepository
import com.example.kotlinstudy.service.EmployeeService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("/employee")
class EmployeeController(val personRepository: PersonRepository, val employeeService: EmployeeService) {

    @PostMapping
    fun createEmployee(@RequestBody @Valid employeeDTO: EmployeeDTO): ResponseEntity<Employee> {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.saveEmployee(employeeDTO))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable @Valid id: UUID) : ResponseEntity<Person>{
        val employee =
            personRepository.findById(id).orElseThrow{
            ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not Found")
        }
        return ResponseEntity.ok(employee)
    }

    @GetMapping
    fun listEmployee(): List<Person>{
        return personRepository.findAll()
    }
}