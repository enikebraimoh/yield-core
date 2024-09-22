package com.yield.core.controller.user

import com.yield.core.model.User
import com.yield.core.model.UserOtherInfo
import com.yield.core.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.Optional

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService,
) {

    @PostMapping
    fun create(@RequestBody user: UserResponse): ResponseEntity<UserResponse> {
        return ResponseEntity(
            userService.createUser(user.toModel()).toResponse(),
            HttpStatus.CREATED
        )
    }

    @GetMapping
    fun listAll(): List<User> = userService.findAll()


    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Optional<User>> {
        val user = userService.findById(id)
        return if (user.isPresent) {
            ResponseEntity(
                user, HttpStatus.OK
            )
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PatchMapping("other-info/{id}")
    fun updateOtherInfo(
        @PathVariable id: Long,
        @RequestBody otherInfo: UserOtherInfoResponse
    ): ResponseEntity<UserResponse> {
        val foundUser = userService.isExists(id)
        if (!foundUser) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }

        val updatedUser = userService.updateUserInfo(id, otherInfo.toModel())

        return ResponseEntity(updatedUser.toResponse(), HttpStatus.OK)
    }

    //    @PutMapping("/other-info/{id}")
//    fun updateOtherIfo(
//        @RequestBody otherInfo: UserOtherInfoResponse,
//        @PathVariable id: UUID
//    ): ApiResponse<UserResponse> =
//        userService.updateOtherInfo(id, otherInfo.toModel())
//            .let { it?.let { it1 -> ApiResponse.success(it1.toResponse()) } }
//            ?: ApiResponse.error(error = ErrorType.CONFLICT, "could not update user")
//
//
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
        farmName, farmLocation, farmDuration, farmSize, farmingType
    )

    private fun UserOtherInfo.toResponse(): UserOtherInfoResponse = UserOtherInfoResponse(
        farmName, farmLocation, farmDuration, farmSize, farmingType
    )

}