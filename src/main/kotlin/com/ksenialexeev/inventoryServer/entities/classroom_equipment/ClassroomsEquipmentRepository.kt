package com.ksenialexeev.inventoryServer.entities.classroom_equipment

import com.ksenialexeev.inventoryServer.dto.ClassroomEquipmentDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ClassroomsEquipmentRepository : JpaRepository<ClassroomEquipment, Long> {
//    @Query(value = "SELECT new com.ksenialexeev.inventoryServer.dto.ClassroomEquipmentDto(cl_eq.id, cl_eq.numberInClassroom) FROM ClassroomEquipment cl_eq")
//    fun findAllByInventoryNumberAndNumberInClassroom(pageable: Pageable): Page<ClassroomEquipmentDto>
}