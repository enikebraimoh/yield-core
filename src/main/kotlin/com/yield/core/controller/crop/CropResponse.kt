package com.yield.core.controller.crop

import java.util.UUID

data class CropResponse (
    val id : UUID,
    val name : String,
    val image : String
)