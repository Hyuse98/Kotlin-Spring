package com.example.kotlinstudy.controller

import com.example.kotlinstudy.dto.ClientDTO
import com.example.kotlinstudy.model.Client
import com.example.kotlinstudy.repository.ClientRepository
import com.example.kotlinstudy.service.ClientService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("/client")
class ClientController(val clientRepository: ClientRepository, val clientService: ClientService) {

    @GetMapping("/{id}")
    fun findById(@PathVariable @Valid id: UUID): ResponseEntity<Client> {

        val client: Optional<Client> = clientRepository.findById(id)
        if (client.isPresent) {
            return ResponseEntity.ok(client.get())
        }
        return ResponseEntity.notFound().build()
    }

    @GetMapping
    fun listClients(): List<Client> {
        return clientRepository.findAll()
    }

    @PostMapping
    fun createClient(@RequestBody @Valid clientDTO: ClientDTO): ResponseEntity<Client> {

        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.saveClient(clientDTO))
    }

    @DeleteMapping("/{id}")
    fun deleteClient(@PathVariable id: UUID) {
        clientRepository.deleteById(id)
    }

    @PutMapping("/{id}")
    fun updateClient(@PathVariable id: UUID, @RequestBody clientDTO: ClientDTO): ResponseEntity<Client> {
        if (!clientRepository.existsById(id)) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Não Encontrado")
        }
        val client = clientDTO.toModel().apply { this.id = id }
        return ResponseEntity.status(HttpStatus.OK).body(clientRepository.save(client))
    }
}