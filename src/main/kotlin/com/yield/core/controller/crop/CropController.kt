package com.yield.core.controller.crop

import com.yield.core.model.Crop
import com.yield.core.service.CropService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/crop")
class CropController (
    private val cropService: CropService
){
    @GetMapping
    fun listAll() : List<CropResponse> = cropService.findAll().map { it.toResponse() }

    private fun Crop.toResponse() : CropResponse = CropResponse(
        id = id,
        name = name,
        image = image
    )
}