package com.yield.core.repository

import com.yield.core.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : CrudRepository<User,Long> {

    fun findByPhoneNumber(phoneNumber : String) : Optional<User>
}