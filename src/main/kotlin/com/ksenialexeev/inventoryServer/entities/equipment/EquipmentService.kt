package com.ksenialexeev.inventoryServer.entities.equipment

import org.springframework.data.domain.Page

interface EquipmentService {
    fun getAllEquipments(pageNumber: Int, pageSize:Int, sortBy:String,sortDir:String):Page<Equipment>
//    fun getById(id:Long): Equipment
//    fun getEquipment(name:String): Equipment
//    fun saveEquipment(equipment: Equipment)
}