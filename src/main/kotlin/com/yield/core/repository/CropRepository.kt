package com.yield.core.repository

import com.yield.core.model.Crop
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class CropRepository {

    private val crops = listOf(
        Crop(id = UUID.randomUUID(), name = "Tomatos", image = ""),
        Crop(id = UUID.randomUUID(), name = "Tomatos", image = ""),
        Crop(id = UUID.randomUUID(), name = "Tomatos", image = "")
    )

    fun findAll() = crops


}