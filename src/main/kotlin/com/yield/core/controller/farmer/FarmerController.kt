package com.yield.core.controller.farmer

import com.yield.core.model.Farmer
import com.yield.core.service.FarmerService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.util.UUID
import kotlin.jvm.Throws

@RestController
@RequestMapping("/api/farmer")
class FarmerController(private val farmerService: FarmerService) {

    @PostMapping
    fun create(@RequestBody farmer: FarmerRequest): FarmerResponse = farmerService.createFarmer(
        farmer = farmer.toModel()
    )?.toResponse() ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "cannot create farmer")

    @GetMapping
    fun listAll(): List<FarmerResponse> = farmerService.findAll().map { it.toResponse() }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): FarmerResponse =
        farmerService.findById(id)?.toResponse() ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "user not found"
        )



    private fun FarmerRequest.toModel(): Farmer = Farmer(
        id = UUID.randomUUID(),
        phoneNumber = phoneNumber,
        password = password
    )

    private fun Farmer.toResponse(): FarmerResponse = FarmerResponse(
        phoneNumber = phoneNumber,
    )

}