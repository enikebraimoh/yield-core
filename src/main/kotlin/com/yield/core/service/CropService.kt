package com.yield.core.service

import com.yield.core.repository.CropRepository
import org.springframework.stereotype.Service

@Service
class CropService(private val cropRepository : CropRepository) {
    fun findAll () = cropRepository.findAll()
}