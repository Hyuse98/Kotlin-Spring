package com.example.kotlinstudy.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import org.hibernate.annotations.GenericGenerator
import java.util.*

@Entity
class Address(

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    var id: UUID? = null,

    @Column(name = "city")
    @NotBlank
    var city: String? = null,
    var client_id: UUID

//    @ManyToOne(cascade = [CascadeType.MERGE])
//    @JoinColumn(name = "client_id")
//    var client: Client? = null
)