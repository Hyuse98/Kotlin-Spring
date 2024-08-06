package com.example.kotlinstudy.service

import com.example.kotlinstudy.dto.EmployeeDTO
import com.example.kotlinstudy.model.Employee
import com.example.kotlinstudy.repository.PersonRepository
import org.springframework.stereotype.Service

@Service
class EmployeeService(val personRepository: PersonRepository) {

    fun saveEmployee(employeeDTO: EmployeeDTO): Employee {
        val employeeExist = personRepository.findByEmail(employeeDTO.email)
        if (employeeExist.isPresent) {
            throw IllegalStateException("Email already in use")
        }
        return personRepository.save(employeeDTO.toModel())
    }
}