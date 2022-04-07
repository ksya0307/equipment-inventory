package com.ksenialexeev.inventoryServer.entities.classroom

import org.springframework.data.domain.Page

interface ClassroomService {
    fun getAllClassrooms(pageNumber: Int, pageSize:Int, sortBy:String,sortDir:String): Page<Classroom>
//    fun getById(id:String): Classroom
//    fun saveClassroom(classroom: Classroom)
}