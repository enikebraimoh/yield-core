package com.yield.core.controller.user

import com.yield.core.service.UserService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/farmer")
class UserController(private val userService: UserService) {

//    @PostMapping
//    fun create(@RequestBody farmer: FarmerRequest): FarmerResponse = userService.createUser(
//        user = farmer.toModel()
//    )?.toResponse() ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "cannot create farmer")
//
//    @GetMapping
//    fun listAll(): List<FarmerResponse> = userService.findAll().map { it.toResponse() }
//
//    @GetMapping("/{id}")
//    fun findById(@PathVariable id: UUID): FarmerResponse =
//        userService.findById(id)?.toResponse() ?: throw ResponseStatusException(
//            HttpStatus.NOT_FOUND,
//            "user not found"
//        )



//    private fun FarmerRequest.toModel(): User = User(
//        id = UUID.randomUUID(),
//        phoneNumber = phoneNumber,
//        password = password
//    )
//
//
//    private fun User.toResponse(): FarmerResponse = FarmerResponse(
//        phoneNumber = phoneNumber,
//    )

}