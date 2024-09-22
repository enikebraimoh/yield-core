package com.yield.core.repository

import com.yield.core.model.Crop
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CropRepository : CrudRepository<Crop,Long> {

}