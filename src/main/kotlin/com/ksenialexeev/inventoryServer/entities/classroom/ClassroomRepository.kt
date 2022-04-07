package com.ksenialexeev.inventoryServer.entities.classroom

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClassroomRepository : JpaRepository<Classroom, String> {
}