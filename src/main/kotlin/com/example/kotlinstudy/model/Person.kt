package com.example.kotlinstudy.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.util.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "personType", discriminatorType = DiscriminatorType.STRING)
open class Person(

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    var id: UUID? = null,

    var name: String? = null,

    var email: String? = null,

    @OneToMany(mappedBy = "personId", fetch = FetchType.EAGER, cascade = [CascadeType.ALL], orphanRemoval = true)
    var addresses: MutableList<Address> = mutableListOf()
) {
}