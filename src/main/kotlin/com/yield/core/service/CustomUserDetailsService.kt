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
    private val userRepository: UserService
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        return userRepository.findByPhone(username).orElseThrow {
            UsernameNotFoundException("User not found")
        }.mapToUserDetails()
    }


    private fun ApplicationUser.mapToUserDetails(): UserDetails =
        User.builder().username(this.phoneNumber).password(this.password).build()


}