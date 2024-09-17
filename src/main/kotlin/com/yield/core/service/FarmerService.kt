package com.yield.core.service

import com.yield.core.model.Farmer
import com.yield.core.repository.FarmerRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class FarmerService(private val farmerRepository: FarmerRepository) {

    fun createFarmer(farmer: Farmer): Farmer? {
        val found = farmerRepository.findById(farmer.id)
        return if (found == null) {
            farmerRepository.save(farmer)
            farmer
        } else return null
    }


    fun findById(id: UUID): Farmer? = farmerRepository.findById(id)

    fun findByPhoneNumber(phoneNumber: String): Farmer? = farmerRepository.findByPhoneNumber(phoneNumber)

    fun findAll(): List<Farmer> = farmerRepository.findAll()


    fun deleteFarmer(id: UUID): Boolean =farmerRepository.deleteFarmer(id)

}