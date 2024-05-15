package com.example.kotlinstudy.service

import com.example.kotlinstudy.dto.ClientDTO
import com.example.kotlinstudy.model.Client
import com.example.kotlinstudy.repository.ClientRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.Optional

@Transactional
@Service
class ClientService(
    val clientRepository: ClientRepository
) {


    fun saveClient(clientDTO: ClientDTO): Client {

        val clientExist: Optional<Client> = clientRepository.findByEmail(clientDTO.email)
        if(clientExist.isPresent){
            throw IllegalStateException("Email already in use.")
        }
        return clientRepository.save(clientDTO.toModel())
    }

}