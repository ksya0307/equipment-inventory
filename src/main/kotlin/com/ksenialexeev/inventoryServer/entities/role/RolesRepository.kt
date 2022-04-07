package com.ksenialexeev.inventoryServer.entities.role

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RolesRepository : JpaRepository<Role, Long>