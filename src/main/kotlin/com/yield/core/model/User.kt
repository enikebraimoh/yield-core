package com.yield.core.model

import java.util.UUID

data class User(
    val id : UUID,
    val firstName : String,
    val middleName : String,
    val lastName : String?,
    val phoneNumber: String,
    val dob : String,
    val gender : String,
    val password : String
)
