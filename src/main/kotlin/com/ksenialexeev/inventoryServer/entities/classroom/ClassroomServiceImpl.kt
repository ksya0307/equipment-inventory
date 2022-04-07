package com.ksenialexeev.inventoryServer.entities.classroom

import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service @RequiredArgsConstructor @Transactional @Slf4j
class ClassroomServiceImpl(private val classroomRepository: ClassroomRepository): ClassroomService {
    override fun getAllClassrooms(pageNumber: Int, pageSize:Int, sortBy:String,sortDir:String): Page<Classroom> {
        val sort: Sort = if(sortDir.equals(Sort.Direction.ASC.name,ignoreCase = true)) Sort.by(sortBy).ascending() else Sort.by(sortBy).descending()
        val pageable:Pageable = PageRequest.of(pageNumber, pageSize, sort)
        return  classroomRepository.findAll(pageable)
    }
//
//    override fun getById(id: String): Classroom {
//
//    }
//
//    override fun saveClassroom(classroom: Classroom) {
//
//    }
}