package com.yield.core.controller.auth

import com.yield.core.model.User
import com.yield.core.repository.UserRepository
import com.yield.core.service.AuthenticationService
import com.yield.core.service.UserService
import com.yield.utils.ApiResponse
import com.yield.utils.ErrorType
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("auth/")
class LoginController(
    private val authenticationService: AuthenticationService,
    private val userService: UserService,
    private val encoder : PasswordEncoder
) {

    @PostMapping("login")
    fun login(@RequestBody authRequest: AuthRequest): ResponseEntity<AuthResponse> {

        val isUserFound = userService.findByPhone(authRequest.phone_number).isPresent

        return if (!isUserFound) {
            ResponseEntity(
                AuthResponse("invalid phone number or password"),
                HttpStatus.NOT_FOUND
            )
        } else {
            return ResponseEntity(
                authenticationService.login(authRequest),
                HttpStatus.OK
            )
        }
    }

    @RequestMapping("signup")
    fun signup(@RequestBody signUpRequest: SignUpRequest): ResponseEntity<SignUpResponse> {
        val isUserFound = userService.findByPhone(signUpRequest.phone_number).isPresent

        return if (isUserFound) {
            ResponseEntity(
                SignUpResponse("user already exists"),
                HttpStatus.NOT_FOUND
            )
        } else {
            userService.createUser(signUpRequest.toModel().copy(password = encoder.encode(signUpRequest.password)))
            return ResponseEntity(
                SignUpResponse("user created, an OTP has been sent to ${signUpRequest.phone_number}"),
                HttpStatus.CREATED
            )
        }
    }


    // MAPPERS
    private fun SignUpRequest.toModel(): User = User(
        firstName = first_name,
        middleName = middle_name,
        lastName = last_name,
        dob = dob,
        gender = gender,
        phoneNumber = phone_number,
        password = password
    )

}