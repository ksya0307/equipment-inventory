package com.ksenialexeev.inventoryServer.entities.classroom_equipment

import com.ksenialexeev.inventoryServer.dto.ClassroomEquipmentDto
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service @RequiredArgsConstructor @Transactional @Slf4j
class ClassroomsEquipmentServiceImpl(private val classroomsEquipmentRepository: ClassroomsEquipmentRepository): ClassroomsEquipmentService {
    override fun getAllClassroomsEquipment(pageNumber: Int, pageSize:Int, sortBy:String,sortDir:String): Page<ClassroomEquipment> {
        val sort:Sort = if(sortDir.equals(Sort.Direction.ASC.name, ignoreCase = true)) Sort.by(sortBy).ascending() else Sort.by(sortBy).descending()
        val pageable: Pageable = PageRequest.of(pageNumber,pageSize,sort)
        return classroomsEquipmentRepository.findAll(pageable)
    }

//    override fun getById(inventoryNumber: Long): ClassroomEquipment {
//
//    }
//
//    override fun saveClassroomsEquipment(classroomsEquipment:ClassroomEquipment) {
//
//    }

//    override fun getInventoryNumberAndClassroomNumber(
//        pageNumber: Int,
//        pageSize: Int,
//        sortBy: String,
//        sortDir: String
//    ): Page<ClassroomEquipmentDto> {
//        val sort:Sort = if(sortDir.equals(Sort.Direction.ASC.name, ignoreCase = true)) Sort.by(sortBy).ascending() else Sort.by(sortBy).descending()
//        val pageable: Pageable = PageRequest.of(pageNumber,pageSize, sort)
//        return classroomsEquipmentRepository.findAllByInventoryNumberAndNumberInClassroom(pageable)
//    }
}