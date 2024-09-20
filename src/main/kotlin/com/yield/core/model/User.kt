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
    var password : String? = null,
    val otherInfo: UserOtherInfo? = null,
)

data class UserOtherInfo(
    val farmName : String?,
    val farmLocation : String?,
    val farmDuration : String?,
    val farmSize: String?,
    val farmingType : String?,
)
