package com.ksenialexeev.inventoryServer.entities.user

import com.ksenialexeev.inventoryServer.dto.UserDto
import org.springframework.data.domain.Page

//@Slf4j для логгов
interface UserService {
    fun getAllUsers(pageNumber: Int, pageSize:Int, sortBy:String,sortDir:String): Page<UserDto>
    fun getById(id:Long): User
    fun getUser(username:String): User
    fun saveUser(user: User)
//    fun addRoleToUser(used_id:Long, role_id:Long)
//    fun users():List<UserDto>
}