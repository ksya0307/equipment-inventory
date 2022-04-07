package com.ksenialexeev.inventoryServer.entities.role

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class RolesServiceImpl(private val rolesRepository: RolesRepository): RolesService {
    override fun getAllRolesList(): List<Role> {
        return rolesRepository.findAll()
    }

    override fun getAllRolesPage(pageNumber: Int, pageSize: Int, sortBy: String, sortDir: String): Page<Role> {
        val sort: Sort = if(sortDir.equals(Sort.Direction.ASC.name, ignoreCase = true)) Sort.by(sortBy).ascending() else Sort.by(sortBy).descending()
        val pageable: Pageable = PageRequest.of(pageNumber,pageSize,sort)
        return rolesRepository.findAll(pageable)
    }

}