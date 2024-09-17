package com.yield.core.repository

import com.yield.core.model.Farmer
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class FarmerRepository {

    private val farmers = mutableListOf(
        Farmer(id = UUID.randomUUID(), phoneNumber = "08140252210","pass"),
        Farmer(id = UUID.randomUUID(), phoneNumber = "08140252211","pass")
    )

    fun save (farmer : Farmer) : Boolean = farmers.add(farmer)

    fun findByPhoneNumber (phoneNumber : String) : Farmer? = farmers.firstOrNull { it.phoneNumber == phoneNumber}

    fun findAll() : List<Farmer> = farmers

    fun findById(id : UUID) : Farmer? = farmers.firstOrNull { it.id == id }

    fun deleteFarmer(id: UUID) : Boolean {
        val farmer = findById(id)

       return farmer?.let {
           farmers.remove(it)
       } ?: false
    }
}