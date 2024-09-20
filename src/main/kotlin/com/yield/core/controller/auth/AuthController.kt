package com.yield.core.controller.auth

import com.yield.core.model.User
import com.yield.core.repository.UserRepository
import com.yield.core.service.AuthenticationService
import com.yield.core.service.UserService
import com.yield.utils.ApiResponse
import com.yield.utils.ErrorType
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("auth/login")
class LoginController(
    private val authenticationService: AuthenticationService,
) {

    @PostMapping
    fun login(@RequestBody authRequest: AuthRequest): ApiResponse<AuthResponse> =
        ApiResponse.success(authenticationService.login(authRequest))

}

@RestController
@RequestMapping("auth/signup")
class SignUpController(
    private val userService: UserService
) {

    @PostMapping
    fun signup(@RequestBody signUpRequest: SignUpRequest): ApiResponse<SignUpResponse> {
        val isUserFound = userService.findByPhoneNumber(signUpRequest.phone_number)
        if (isUserFound == null) {
            val resp = userService.createUser(signUpRequest.toModel()).let {
                ApiResponse.success(SignUpResponse("User created"))
            }
            return resp

        }

        return ApiResponse.error(ErrorType.CONFLICT, "user already exists")
    }

    private fun SignUpRequest.toModel(): User = User(
        id = UUID.randomUUID(),
        firstName = first_name,
        middleName = middle_name,
        lastName = last_name,
        dob = dob,
        gender = gender,
        phoneNumber = phone_number,
        password = password
    )

}
