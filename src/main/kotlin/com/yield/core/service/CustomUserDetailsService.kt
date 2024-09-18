package com.yield.core.service

import com.yield.core.repository.UserRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

typealias ApplicationUser = com.yield.core.model.User

@Service
class CustomUserDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails =
        userRepository.findByPhoneNumber(username)?.mapToUserDetails()
            ?: throw UsernameNotFoundException("User not found")


    private fun ApplicationUser.mapToUserDetails(): UserDetails =
        User.builder().username(this.phoneNumber).password(this.password).build()


}