//package com.yield.core.service
//
//import com.yield.core.config.JwtProperties
//import com.yield.core.controller.auth.AuthRequest
//import com.yield.core.controller.auth.AuthResponse
//import com.yield.core.controller.auth.SignUpRequest
//import com.yield.core.controller.auth.SignUpResponse
//import com.yield.core.model.User
//import org.springframework.security.authentication.AuthenticationManager
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
//import org.springframework.stereotype.Service
//import java.util.*
//
//@Service
//class AuthenticationService(
//    private val authenticationManager: AuthenticationManager,
//    private val userDetailsService: CustomUserDetailsService,
//    private val tokenService: TokenService,
//    private val jwtProperties: JwtProperties,
//    //  private val userService: UserService
//) {
//    fun login(authRequest: AuthRequest): AuthResponse {
//
//        authenticationManager.authenticate(
//            UsernamePasswordAuthenticationToken(
//                authRequest.phone_number,
//                authRequest.password
//            )
//        )
//
//        val user = userDetailsService.loadUserByUsername(authRequest.phone_number)
//
//        val accessToken = tokenService.generate(
//            userDetails = user,
//            expirationDate = Date(System.currentTimeMillis() + jwtProperties.accessTokenExpiration)
//        )
//
//        return AuthResponse(
//            accessToken = accessToken
//        )
//
//    }
//
//
//
//}
