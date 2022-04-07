package com.ksenialexeev.inventoryServer.entities.equipment_belonging

import org.springframework.data.domain.Page

interface EquipmentBelongingService {
    fun getAllEquipmentBelonging(pageNumber: Int, pageSize:Int, sortBy:String,sortDir:String):Page<EquipmentBelonging>
//    fun getById(id:Long): EquipmentBelonging
//    fun saveEquipmentBelonging(equipmentBelonging: EquipmentBelonging)
}