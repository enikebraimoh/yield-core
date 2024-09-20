package com.yield.core.controller.user

import com.yield.core.controller.auth.SignUpRequest
import com.yield.core.controller.auth.SignUpResponse
import com.yield.core.model.User
import com.yield.core.model.UserOtherInfo
import com.yield.core.service.UserService
import com.yield.utils.ApiResponse
import com.yield.utils.ErrorType
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

//    @PostMapping
//    fun create(@RequestBody farmer: FarmerRequest): FarmerResponse = userService.createUser(
//        user = farmer.toModel()
//    )?.toResponse() ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "cannot create farmer")
//
    @GetMapping
    fun listAll(): List<User> = userService.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): User? =
        userService.findById(id).let { it } ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "user not found"
        )

    @PutMapping("/other-info/{id}")
    fun updateOtherIfo(
        @RequestBody otherInfo: UserOtherInfoResponse,
        @PathVariable id: UUID
    ): ApiResponse<UserResponse> =
        userService.updateOtherInfo(id, otherInfo.toModel())
            .let { it?.let { it1 -> ApiResponse.success(it1.toResponse()) } }
            ?: ApiResponse.error(error = ErrorType.CONFLICT, "could not update user")


    private fun UserResponse.toModel(): User = User(
        id = id,
        firstName = firstName,
        middleName = middleName,
        lastName = lastName,
        phoneNumber = phoneNumber,
        dob = dob,
        gender = gender,
        otherInfo = otherInfo?.toModel()
    )

    private fun User.toResponse(): UserResponse = UserResponse(
        id = id,
        firstName = firstName,
        middleName = middleName,
        lastName = lastName,
        phoneNumber = phoneNumber,
        dob = dob,
        gender = gender,
        otherInfo = otherInfo?.toResponse()
    )

    private fun UserOtherInfoResponse.toModel(): UserOtherInfo = UserOtherInfo(
        farm_name, farm_location, farm_duraion, farm_size, farming_type
    )

    private fun UserOtherInfo.toResponse(): UserOtherInfoResponse = UserOtherInfoResponse(
        farmName, farmLocation, farmDuration, farmSize, farmingType
    )


}