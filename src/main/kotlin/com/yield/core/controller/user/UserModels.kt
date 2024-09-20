package com.yield.core.controller.user

import java.util.*

data class UserResponse(
    val id : UUID,
    val firstName : String,
    val middleName : String,
    val lastName : String?,
    val phoneNumber: String,
    val dob : String,
    val gender : String,
    val otherInfo: UserOtherInfoResponse?,
)

data class UserOtherInfoResponse(
    val farm_name : String?,
    val farm_location : String?,
    val farm_duraion : String?,
    val farm_size: String?,
    val farming_type : String?,
)