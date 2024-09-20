package com.yield.core.service

import com.yield.core.model.User
import com.yield.core.model.UserOtherInfo
import com.yield.core.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository) {

    fun createUser(user: User): User? {
        val found = userRepository.findByPhoneNumber(user.phoneNumber)
        return if (found == null) {
            userRepository.save(user)
            user
        } else return null
    }


    fun findById(id: UUID): User? = userRepository.findById(id)

    fun updateOtherInfo(id : UUID, data: UserOtherInfo): User? = userRepository.updateOtherInfo(id,data)


    fun findByPhoneNumber(phoneNumber: String): User? = userRepository.findByPhoneNumber(phoneNumber)

    fun findAll(): List<User> = userRepository.findAll()


    fun deleteFarmer(id: UUID): Boolean =userRepository.deleteFarmer(id)

}