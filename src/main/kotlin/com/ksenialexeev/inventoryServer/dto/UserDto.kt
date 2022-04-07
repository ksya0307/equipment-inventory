package com.ksenialexeev.inventoryServer.dto

import lombok.AllArgsConstructor
import lombok.NoArgsConstructor


@NoArgsConstructor
@AllArgsConstructor
class UserDto(id:Long, username:String){
    val id:Long?
    val username:String?
    init {
        this.id = id
        this.username = username
    }
}
