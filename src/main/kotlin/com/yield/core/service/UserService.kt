package com.yield.core.service

import com.yield.core.controller.user.UserResponse
import com.yield.core.model.User
import com.yield.core.model.UserOtherInfo
import com.yield.core.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun createUser(user: User): User = userRepository.save(user)

    fun findById(id: Long): Optional<User> = userRepository.findById(id)

    fun isExists(phoneNumber: String): Boolean = userRepository.findByPhoneNumber(phoneNumber).isPresent

    //    fun updateOtherInfo(id : UUID, data: UserOtherInfo): User
    //
    //    fun findByPhoneNumber(phoneNumber: String): User
    //

    fun findAll(): List<User> = userRepository.findAll().toList()

    fun findByPhone(phoneNumber : String) : Optional<User> = userRepository.findByPhoneNumber(phoneNumber)

    fun updateUserInfo(id: Long, userOtherInfo: UserOtherInfo): User {
        val user = findById(id).get()
        userRepository.save(user.copy(otherInfo = userOtherInfo))
        return user
    }
//
//    fun deleteFarmer(id: UUID): Boolean

}