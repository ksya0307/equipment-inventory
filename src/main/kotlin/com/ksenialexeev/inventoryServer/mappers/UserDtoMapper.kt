package com.ksenialexeev.inventoryServer.mappers

import com.ksenialexeev.inventoryServer.dto.UserDto
import com.ksenialexeev.inventoryServer.entities.user.User
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy
import org.springframework.data.domain.Page

//MapStruct для связывания наших DTO классов и Entities
@Mapper(
    componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface UserDtoMapper {
    fun userDtoList(user: Page<User>): List<UserDto>
}