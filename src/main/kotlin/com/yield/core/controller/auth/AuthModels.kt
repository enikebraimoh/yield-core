package com.yield.core.controller.auth

data class AuthRequest (
    val phone_number : String,
    val password : String
)

data class AuthResponse (
    val accessToken : String
)

data class SignUpRequest(
    val first_name : String,
    val middle_name : String,
    val last_name : String,
    val phone_number: String,
    val dob : String,
    val gender : String,
    val password : String
)

data class SignUpResponse (
    val message : String
)