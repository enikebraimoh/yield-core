package com.yield.core.controller.user

import io.jsonwebtoken.security.Password


class UserResponse(
    val id: Long = 0,
    val firstName: String? = null,
    val middleName: String = "",
    val lastName: String? = null,
    val phoneNumber: String = "",
    val dob: String = "",
    val gender: String = "",
    var password: String?,
    val otherInfo: UserOtherInfoResponse? = null,
)

class UserOtherInfoResponse(
    val farmName: String? = null,
    val farmLocation: String? = null,
    val farmDuration: String? = null,
    val farmSize: String? = null,
    val farmingType: String? = null,
)
