package com.yield.core.repository

import com.yield.core.model.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class UserRepository(
    private val encoder: PasswordEncoder
) {

    private val users = mutableListOf(
        User(
            id = UUID.randomUUID(),
            phoneNumber = "08140252210",
            password = encoder.encode("Enike123"),
            firstName = "Enike",
            middleName = "Richard",
            lastName = "Braimoh",
            dob = "23/12/2024",
            gender = "Male",
        ),
        User(
            id = UUID.randomUUID(),
            phoneNumber = "08140252211",
            password = encoder.encode("Pass"),
            firstName = "Henry",
            middleName = "Adebayo",
            lastName = "Marvel",
            dob = "23/12/2024",
            gender = "Male",
        )
    )

    fun save(user: User): Boolean {
        val updatedUser = user.copy(
            password = encoder.encode(user.password)
        )

        return users.add(updatedUser)
    }

    fun findByPhoneNumber(phoneNumber: String): User? = users.firstOrNull { it.phoneNumber == phoneNumber }

    fun findAll(): List<User> = users

    fun findById(id: UUID): User? = users.firstOrNull { it.id == id }

    fun deleteFarmer(id: UUID): Boolean {
        val farmer = findById(id)

        return farmer?.let {
            users.remove(it)
        } ?: false
    }
}