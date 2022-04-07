package com.ksenialexeev.inventoryServer.entities.classroom_equipment

import com.ksenialexeev.inventoryServer.dto.ClassroomEquipmentDto
import org.springframework.data.domain.Page

interface ClassroomsEquipmentService {
    fun getAllClassroomsEquipment(pageNumber: Int, pageSize:Int, sortBy:String,sortDir:String):Page<ClassroomEquipment>
//    fun getById(inventoryNumber:Long): ClassroomEquipment
//    fun saveClassroomsEquipment(classroomsEquipment: ClassroomEquipment)
//    fun getInventoryNumberAndClassroomNumber(pageNumber: Int, pageSize:Int, sortBy:String,sortDir:String):Page<ClassroomEquipmentDto>
}