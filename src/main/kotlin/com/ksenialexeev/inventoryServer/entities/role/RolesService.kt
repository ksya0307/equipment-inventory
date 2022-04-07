package com.ksenialexeev.inventoryServer.entities.role

import org.springframework.data.domain.Page

interface RolesService {
    fun getAllRolesList():List<Role>
    fun getAllRolesPage(pageNumber: Int, pageSize:Int, sortBy:String,sortDir:String): Page<Role>
}