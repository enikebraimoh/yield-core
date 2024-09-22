package com.yield.core.model

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "users")
data class  User(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    val id: Long = 0, // Default ID generation
    val firstName: String? = null,
    val middleName: String = "",
    val lastName: String? = null,
    val phoneNumber: String = "",
    val dob: String = "",
    val gender: String = "",
    var password: String? = null,
    @Embedded
    val otherInfo: UserOtherInfo? = null,
)

@Embeddable
data class UserOtherInfo(
    val farmName: String? = null,
    val farmLocation: String? = null,
    val farmDuration: String? = null,
    val farmSize: String? = null,
    val farmingType: String? = null,
)
