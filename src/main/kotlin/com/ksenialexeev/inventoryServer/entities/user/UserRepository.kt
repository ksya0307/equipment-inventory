package com.ksenialexeev.inventoryServer.entities.user

import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username:String): User

    @Query(value = "SELECT new com.ksenialexeev.inventoryServer.dto.UserDto(us.id, us.username) FROM User us")
    fun findAllUsers(pageable: Pageable): List<User>
}