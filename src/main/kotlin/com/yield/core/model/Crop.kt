package com.yield.core.model

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "crops")
data class Crop(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "crop_id_seq")
    val id: Long = 0, // Default ID value
    val name: String = "",
    val image: String = "",
    val farmerId: String = ""
) {
    // No-argument constructor for Hibernate
    constructor() : this(
        id = 0, // Default value
        name = "",
        image = "",
        farmerId = ""
    )
}
